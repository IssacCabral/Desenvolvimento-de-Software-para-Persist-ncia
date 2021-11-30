CREATE TABLE funcionario(
	id SERIAL,
	cpf VARCHAR(20) UNIQUE not null,
	matricula INTEGER UNIQUE not null,
	nome VARCHAR(40) not null,
	email VARCHAR(40),
	telefone VARCHAR(20),

	CONSTRAINT funcionario_pkey PRIMARY KEY (id)
);