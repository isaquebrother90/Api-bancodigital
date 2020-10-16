CREATE TABLE usuario (
	id INT(11) PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(191) NOT NULL UNIQUE,
	senha VARCHAR(191) NOT NULL
);

INSERT INTO usuario (email, senha) VALUES
('admin@teste.com', '$2y$12$sSLCsH9Q.irGZhYl2zaQweO5wIhlExwiqZyerdmMSVzSRr.h0.zzS');