package com.banco.digital.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "conta_pf")
public class ContaPfEntity {

	private int agencia;
	private int conta;
	private int codBanco;
	private double saldo;
	
	public ContaPfEntity(double saldo) {
		super();
		this.saldo = saldo;
		saldo = 0;
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



	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JsonIgnoreProperties("conta_pf")
	private ClienteEntity cliente;
	
}
