package com.banco.digital.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.digital.entities.ContaPfEntity;
import com.banco.digital.repositories.ContaPfRepository;
import com.banco.digital.resources.BaseController;
import com.banco.digital.services.ContaPfService;

@RestController
@RequestMapping("/contapf")
public class ContaPfController extends BaseController<ContaPfEntity, ContaPfRepository, ContaPfService> {

	@PostMapping("/{id}")
	@Transactional
	public ResponseEntity<ContaPfEntity> store(@Valid @RequestBody ContaPfEntity entity) {
		ContaPfEntity criaConta = service.store(entity);
		return ResponseEntity.status(200).body(criaConta);
	}
}
