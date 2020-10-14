package com.banco.digital.resources;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseController<Entities extends BaseEntity, Repositories extends BaseRepository<Entities>, Services extends BaseService<Entities, Repositories>> {

	@Autowired // serviço
	protected Services service;

	@PostMapping // Cadastrar uma cliente, primeira fase
	@Transactional
	public ResponseEntity<Entities> store(@Valid @RequestBody Entities entity) {
		Entities novaProposta = service.store(entity);
		return ResponseEntity.status(201).body(novaProposta);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entities> show(@PathVariable("id") Integer id) {
		Entities entity = service.getOne(id);
		return ResponseEntity.ok(entity);
	}
	
}