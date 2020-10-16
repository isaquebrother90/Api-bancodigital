package com.banco.digital.entities;

import javax.persistence.Entity;

import com.banco.digital.resources.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario extends BaseEntity{
	private String email;
	private String senha;
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
