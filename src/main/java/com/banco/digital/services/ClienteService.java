package com.banco.digital.services;

import org.springframework.stereotype.Service;

import com.banco.digital.dtos.ClienteDto;
import com.banco.digital.entities.ClienteEntity;
import com.banco.digital.repositories.ClienteRepository;
import com.banco.digital.resources.BaseService;

@Service
public class ClienteService extends BaseService<ClienteEntity, ClienteRepository> {

	public ClienteEntity updateFotoCpf(Integer id, ClienteDto clienteDto) {
		ClienteEntity cliente = this.getOne(id);
		cliente.setFotoCpf(clienteDto.getFotoCpf());
		return this.store(cliente);
	}
	
}
