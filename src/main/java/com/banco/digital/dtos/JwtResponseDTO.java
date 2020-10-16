package com.banco.digital.dtos;

public class JwtResponseDTO {
	private final String token;

	public JwtResponseDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

}
