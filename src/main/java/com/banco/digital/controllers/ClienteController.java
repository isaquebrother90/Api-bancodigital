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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags = "cliente", description = "Esse Controller é responsável pelos endpoints de cliente")
public class ClienteController extends BaseController<ClienteEntity, ClienteRepository, ClienteService> {

	@ApiOperation(value = "Salvar uma foto do cliente", notes = "Atualiza o campo fotoCpf da tabela cliente do DB, enviando a imagem para ClienteDto e depois salvando na tabela de clientes.")
	@ApiImplicitParams(@ApiImplicitParam(name = "nome", value = "Nome do contato"))

	@PatchMapping("/{id}/fotoCpf")
	@Transactional
	public ResponseEntity<ClienteEntity> atualizaFotoCpf(@PathVariable("id") Integer id,
			@RequestBody ClienteDto clienteDto, UriComponentsBuilder b) {
		ClienteEntity cliente = service.updateFotoCpf(id, clienteDto);
		UriComponents uriComponents = b.path("/customers/{id}").buildAndExpand(id);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponents.toUri());
		return new ResponseEntity<ClienteEntity>(cliente, headers, HttpStatus.CREATED);
	}

}
