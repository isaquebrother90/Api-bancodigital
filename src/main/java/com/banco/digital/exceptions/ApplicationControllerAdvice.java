package com.banco.digital.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex) {
		Map<String, Object> resposta = new HashMap<>();
		resposta.put("mensagem", ex.getReason());
		resposta.put("status", "error");
		resposta.put("code", ex.getStatus().value());
		return ResponseEntity.status(ex.getStatus()).body(resposta);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, Object> resposta = new HashMap<>();
		resposta.put("mensagem", "Argumento inválido");
		resposta.put("code", 400);
		resposta.put("status", "error");
		resposta.put("erros",
				ex.getBindingResult().getFieldErrors().stream().map(
						error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
						.collect(Collectors.toList()));

		return resposta;
	}
}
