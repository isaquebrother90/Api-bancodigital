package com.banco.digital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banco.digital.config.JwtTokenUtil;
import com.banco.digital.dtos.JwtResponseDTO;
import com.banco.digital.services.JwtUserDetailsService;
import com.banco.digital.dtos.UserDTO;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getEmail(), authenticationRequest.getSenha());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponseDTO(token));
	}

	private void authenticate(String email, String senha) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, senha));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
