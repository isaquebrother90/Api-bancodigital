package com.banco.digital.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.banco.digital.resources.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "contapf")
public class ContaPfEntity extends BaseEntity {

	private int agencia;
	private int conta;
	private int codBanco;
	private double saldo = 0;
	@Column(name = "cliente_id", nullable = false)
	private Integer clienteId;
	
	

	public ContaPfEntity() {
		super();
	}



	public ContaPfEntity(int agencia, int conta, int codBanco, double saldo, Integer clienteId) {
		super();
		this.agencia = agencia;
		this.conta = conta;
		this.codBanco = codBanco;
		this.saldo = saldo;
		this.clienteId = clienteId;
	}



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

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JsonIgnoreProperties("contaPf")
	private ClienteEntity cliente;
	
}
