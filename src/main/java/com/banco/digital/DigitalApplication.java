package com.banco.digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class DigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalApplication.class, args);
	}

}
