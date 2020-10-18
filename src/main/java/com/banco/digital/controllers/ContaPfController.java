package com.banco.digital.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.digital.dtos.ContaPfDto;
import com.banco.digital.entities.ContaPfEntity;
import com.banco.digital.repositories.ContaPfRepository;
import com.banco.digital.resources.BaseController;
import com.banco.digital.services.ContaPfService;

@RestController
@RequestMapping("/contapf")
public class ContaPfController extends BaseController<ContaPfEntity, ContaPfRepository, ContaPfService> {

	
	/*
	 * public ResponseEntity<ContaPfEntity> store(@Valid @RequestBody ContaPfEntity
	 * entity) { ContaPfEntity criaConta = service.store(entity); return
	 * ResponseEntity.status(200).body(criaConta); }
	 */
	@PostMapping("/{id}")
	@Transactional
	public ResponseEntity<ContaPfEntity> store(@Valid @RequestBody ContaPfDto dto) {
	    ContaPfEntity cpEntity = service.store(dto.transformaParaObjeto());
	    return new ResponseEntity<>(cpEntity, HttpStatus.CREATED);
}
}