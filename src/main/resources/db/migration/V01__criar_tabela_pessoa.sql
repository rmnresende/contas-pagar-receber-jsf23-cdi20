CREATE TABLE pessoa(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome_nomefantasia VARCHAR(50) NOT NULL,
	email VARCHAR(50),
	ativo tinyint NOT NULL,
	data_cadastro DATE NOT NULL,
	telefone VARCHAR(14),
	tipo_pessoa VARCHAR(2),
	sobrenome VARCHAR(50),
	razao_social VARCHAR(50),
	cpf VARCHAR(11),
	cnpj VARCHAR(14)
)ENGINE=innoDB DEFAULT CHARSET=utf8;