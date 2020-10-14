package com.banco.digital.dtos;

import javax.validation.constraints.NotNull;

public class ClienteDto {
	
	@NotNull(message = "A foto é obrigatória!")
	private String fotoCpf;

	public String getFotoCpf() {
		return fotoCpf;
	}

	public void setFotoCpf(String fotoCpf) {
		this.fotoCpf = fotoCpf;
	}
	
}
