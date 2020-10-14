CREATE TABLE endereco (
  	id integer(11) PRIMARY KEY AUTO_INCREMENT,
    cep	VARCHAR(100) NOT NULL,
    rua VARCHAR(190) NOT NULL,
    bairro VARCHAR(190) NOT NULL,
    complemento VARCHAR(190) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    cliente_id integer(11) not null, 
    FOREIGN KEY(cliente_id) REFERENCES cliente(id)
);