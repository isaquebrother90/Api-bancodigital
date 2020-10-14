package com.banco.digital.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.banco.digital.resources.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter
@Setter
public class EnderecoEntity extends BaseEntity {

	@NotNull(message = "O cep é obrigatório!")
	@Pattern(regexp="\\d{5}-\\d{3}")
	private String cep;

	@NotNull(message = "A rua é obrigatória!")
	private String rua;

	@NotNull(message = "O bairro é obrigatório!")
	private String bairro;

	@NotNull(message = "O complemento é obrigatório!")
	private String complemento;

	@NotNull(message = "A cidade é obrigatória!")
	private String cidade;

	@NotNull(message = "O estado é obrigatório!")
	private String estado;
	
	@Column(name = "cliente_id", nullable = false)
	private Integer clienteId;
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JsonIgnoreProperties("endereco")
	private ClienteEntity cliente;

	@Override
	public String toString() {
		return "EnderecoEntity [cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", complemento=" + complemento
				+ ", cidade=" + cidade + ", estado=" + estado + ", cliente=" + cliente + "]";
	}


	
	
	

}
