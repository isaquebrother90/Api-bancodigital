package com.banco.digital.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.banco.digital.entities.Usuario;
import com.banco.digital.repositories.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario != null) {
			return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
		}
	}
}