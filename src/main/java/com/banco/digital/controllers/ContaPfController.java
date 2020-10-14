package com.banco.digital.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contapf")
public class ContaPfController extends BaseController<ContaPfEntity, ContaPfRepository, ContaPfService> {

}
