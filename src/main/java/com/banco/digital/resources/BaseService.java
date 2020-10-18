package com.banco.digital.resources;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.banco.digital.entities.ClienteEntity;
import com.banco.digital.interfaces.ValidaDataNascimento;

public class BaseService<Entities extends BaseEntity, Repositories extends BaseRepository<Entities>> implements ValidaDataNascimento {

	@Autowired
	protected Repositories repository;
	
	public List<Entities> getAll() {
		return repository.findAll();
	}

	public Entities store(Entities entity) {
		return repository.save(entity);
	}

	public Entities getOne(Integer id) {
		Optional<Entities> optional = repository.findById(id);
		if (!optional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity não foi encontrada!");
		}
		Entities entity = optional.get();
		return entity;
	}

	public Entities update(Integer id, Entities entity) {
		this.getOne(id);
		entity.setId(id);
		return this.store(entity);
	}

	public void destroy(Integer id) {
		Entities entity = this.getOne(id);
		repository.delete(entity);
	}

	@Override
	public boolean ValidandoDataNascimento(ClienteEntity dataNascimento) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @Override public boolean ValidandoDataNascimento(Cliente dataNascimento) {
	 * DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 * LocalDate dataVerificada = LocalDate.parse(dataNascimento, dataFormatada);
	 * LocalDate hoje = LocalDate.now(); int idade = 18; if (idade > 18 && hoje ==
	 * LocalDate.now()) { return dataVerificada.compareTo(hoje) <= 0; } else return
	 * false;
	 * 
	 * }
	 */

}
