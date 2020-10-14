package com.banco.digital.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.banco.digital.dtos.ClienteDto;
import com.banco.digital.entities.ClienteEntity;
import com.banco.digital.repositories.ClienteRepository;
import com.banco.digital.resources.BaseController;
import com.banco.digital.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController<ClienteEntity, ClienteRepository, ClienteService> {
	
	@PatchMapping("/{id}/fotoCpf")
	@Transactional
	public ResponseEntity<ClienteEntity> atualizaFotoCpf (@PathVariable ("id") Integer id, @RequestBody ClienteDto clienteDto, UriComponentsBuilder b) {
		ClienteEntity cliente = service.updateFotoCpf(id, clienteDto);
		UriComponents uriComponents = 
		        b.path("/customers/{id}").buildAndExpand(id);

		    HttpHeaders headers = new HttpHeaders();
		    headers.setLocation(uriComponents.toUri());
		    return new ResponseEntity<ClienteEntity>(cliente, headers, HttpStatus.CREATED);
	}

}
