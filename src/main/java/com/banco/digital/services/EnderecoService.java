package com.banco.digital.services;

import org.springframework.stereotype.Service;

import com.banco.digital.entities.ClienteEntity;
import com.banco.digital.entities.EnderecoEntity;
import com.banco.digital.repositories.ClienteRepository;
import com.banco.digital.repositories.EnderecoRepository;
import com.banco.digital.resources.BaseService;

@Service
public class EnderecoService extends BaseService<EnderecoEntity, EnderecoRepository> {

}
