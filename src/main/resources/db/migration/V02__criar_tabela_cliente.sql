CREATE TABLE cliente(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_pessoa BIGINT(20) NOT NULL,
	limite_credito decimal(15,2),
	FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
)ENGINE=innoDB DEFAULT CHARSET=utf8;