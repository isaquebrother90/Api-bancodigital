CREATE TABLE contapf (
  	id integer(11) PRIMARY KEY AUTO_INCREMENT,
    agencia int (11) NOT NULL,
    conta int (11) NOT NULL,
    cod_banco int (11) NOT NULL,
    saldo double (11) NOT NULL,
    FOREIGN KEY(cliente_id) REFERENCES cliente(id)
);