package com.banco.digital.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conta_pf")
public class ContaPfEntity {

	private String agencia;
	private String conta;
	private String codigo;
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
