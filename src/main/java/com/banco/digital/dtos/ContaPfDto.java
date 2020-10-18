package com.banco.digital.dtos;

import javax.persistence.Column;

import com.banco.digital.entities.ContaPfEntity;

public class ContaPfDto {

	private int agencia;
	private int conta;
	private int codBanco;
	private double saldo = 0;
	@Column(name = "cliente_id", nullable = false)
	private Integer clienteId;
	

	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getCodBanco() {
		return codBanco;
	}
	public void setCodBanco(int codBanco) {
		this.codBanco = codBanco;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
	public ContaPfEntity transformaParaObjeto(){
	    return new ContaPfEntity(agencia, conta, codBanco, saldo, clienteId);
	}
	
	
}
