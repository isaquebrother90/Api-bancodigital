package com.banco.digital.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.digital.entities.EnderecoEntity;
import com.banco.digital.repositories.EnderecoRepository;
import com.banco.digital.resources.BaseController;
import com.banco.digital.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController extends BaseController<EnderecoEntity, EnderecoRepository, EnderecoService> {
	
}
