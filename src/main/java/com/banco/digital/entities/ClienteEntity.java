package com.banco.digital.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import com.banco.digital.resources.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cliente")
public class ClienteEntity extends BaseEntity {

	@NotNull(message = "O nome do cliente é obrigatório!")
	@Column(name = "nome")
	private String nome;

	@NotNull(message = "O sobrenome do cliente é obrigatório!")
	private String sobrenome;

	@NotNull(message = "A data de nascimento é obrigatória!")
	private String dataNascimento;

	private int idade;

	@NotNull(message = "O cpf é obrigatório!")
	@CPF
	private String cpf;

	@NotNull(message = "O email é obrigatório!")
	@Email
	@Column(name = "email")
	private String email;

	private String telefone;
	
	private String fotoCpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public String getFotoCpf() {
		return fotoCpf;
	}

	public void setFotoCpf(String fotoCpf) {
		this.fotoCpf = fotoCpf;
	}

	public ContaPfEntity getConta_pf() {
		return contaPf;
	}

	public void setConta_pf(ContaPfEntity conta_pf) {
		this.contaPf = conta_pf;
	}



	@OneToOne(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private EnderecoEntity endereco;
	
	@OneToOne(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private ContaPfEntity contaPf;

	/*
	 * @OneToOne(mappedBy = "cliente")
	 * 
	 * @JsonIgnoreProperties("cliente") private PessoaEntity pessoa;
	 */

}
