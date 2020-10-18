package com.banco.digital.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public abstract class PessoaEntity {

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
	
	public PessoaEntity() {
		super();
	}

	public PessoaEntity(@NotNull(message = "O nome do cliente é obrigatório!") String nome,
			@NotNull(message = "O sobrenome do cliente é obrigatório!") String sobrenome,
			@NotNull(message = "A data de nascimento é obrigatória!") String dataNascimento, int idade,
			@NotNull(message = "O cpf é obrigatório!") @CPF String cpf,
			@NotNull(message = "O email é obrigatório!") @Email String email, String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

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

	@Override
	public String toString() {
		return "PessoaEntity [nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento=" + dataNascimento
				+ ", idade=" + idade + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + "]";
	}

	
	
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "cliente_id", referencedColumnName = "id")
	 * 
	 * @JsonIgnoreProperties("pessoa") private ClienteEntity cliente;
	 */
	 
	
	
	
}
