CREATE TABLE IF NOT EXISTS tipo(
	id serial PRIMARY KEY,
	nome text NOT NULL,
	descricao text NOT NULL,
	codDescricao integer NOT NULL
);

/* Códigos:
*		1: tipo de usuário
*		2: tipo de responsável pelo aluno
*		3: tipo de contato
*		4: Turno (refeição)
*/
INSERT INTO tipo VALUES (default, 'Webmaster', 'Tipo de usuário', 1);
INSERT INTO tipo VALUES (default, 'Administrador', 'Tipo de usuário', 1);
INSERT INTO tipo VALUES (default, 'Pai', 'Tipo de responsável', 2);
INSERT INTO tipo VALUES (default, 'Mãe', 'Tipo de responsável', 2);
INSERT INTO tipo VALUES (default, 'Responsável', 'Tipo de responsável', 2);
INSERT INTO tipo VALUES (default, 'Email', 'Tipo de contato', 3);
INSERT INTO tipo VALUES (default, 'Celular', 'Tipo de contato', 3);
INSERT INTO tipo VALUES (default, 'Telefone', 'Tipo de contato', 3);
INSERT INTO tipo VALUES (default, 'Lanche Matutino', 'Turno (refeição)', 4);
INSERT INTO tipo VALUES (default, 'Almoço', 'Turno (refeição)', 4);
INSERT INTO tipo VALUES (default, 'Lanche Vespertino', 'Turno (refeição)', 4);
INSERT INTO tipo VALUES (default, 'Noturno', 'Turno (refeição)', 4);

CREATE TABLE IF NOT EXISTS estado(
	id serial PRIMARY KEY,
	nome text NOT NULL,
	sigla char(20) NOT NULL
);
INSERT INTO estado VALUES (default, 'Acre', 'AC');
INSERT INTO estado VALUES (default, 'Alagoas', 'AL');
INSERT INTO estado VALUES (default, 'Amapá', 'AP');
INSERT INTO estado VALUES (default, 'Amazonas', 'AM');
INSERT INTO estado VALUES (default, 'Bahia', 'BA');
INSERT INTO estado VALUES (default, 'Ceará', 'CE');
INSERT INTO estado VALUES (default, 'Distrito Federal', 'DF');
INSERT INTO estado VALUES (default, 'Espírito Santo', 'ES');
INSERT INTO estado VALUES (default, 'Goiás', 'GO');
INSERT INTO estado VALUES (default, 'Maranhão', 'MA');
INSERT INTO estado VALUES (default, 'Mato Grosso', 'MT');
INSERT INTO estado VALUES (default, 'Mato Grosso do Sul', 'MS');
INSERT INTO estado VALUES (default, 'Minas Gerais', 'MG');
INSERT INTO estado VALUES (default, 'Pará', 'PA');
INSERT INTO estado VALUES (default, 'Paraíba', 'PB');
INSERT INTO estado VALUES (default, 'Paraná', 'PR');
INSERT INTO estado VALUES (default, 'Pernambuco', 'PE');
INSERT INTO estado VALUES (default, 'Piauí', 'PI');
INSERT INTO estado VALUES (default, 'Rio de Janeiro', 'RJ');
INSERT INTO estado VALUES (default, 'Rio Grande do Norte', 'RN');
INSERT INTO estado VALUES (default, 'Rio Grande do Sul', 'RS');
INSERT INTO estado VALUES (default, 'Rondônia', 'RO');
INSERT INTO estado VALUES (default, 'Roraima', 'RR');
INSERT INTO estado VALUES (default, 'Santa Catarina', 'SC');
INSERT INTO estado VALUES (default, 'São Paulo', 'SP');
INSERT INTO estado VALUES (default, 'Sergipe', 'SE');
INSERT INTO estado VALUES (default, 'Tocantins', 'TO');

CREATE TABLE IF NOT EXISTS endereco(
	id serial PRIMARY KEY,
	rua text NOT NULL,
	bairro text NOT NULL,
	num integer NOT NULL DEFAULT 0,
	cidade text NOT NULL,
	estado integer NOT NULL,
	cep varchar(20),
	
	FOREIGN KEY (estado) REFERENCES estado(id) 
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);
INSERT INTO endereco VALUES (default, "Rua onde a maria mora", "Bairro", 120, "Videira", 24, "89560-000");
INSERT INTO endereco VALUES (default, "Rua onde a eduarda mora", "Bairro", 121, "Videira", 24, "89560-000");
INSERT INTO endereco VALUES (default, "Rua onde a talia mora", "Bairro", 122, "Videira", 24, "89560-000");

CREATE TABLE IF NOT EXISTS aluno(
	id serial PRIMARY KEY,
	rg varchar(20) UNIQUE NOT NULL,
	cpf varchar(30) UNIQUE NOT NULL,
	matricula varchar(50) UNIQUE NOT NULL,
	endereco integer NOT NULL,
	dataNascimento date NOT NULL,
	status boolean DEFAULT TRUE,
	nome text NOT NULL,
	
	FOREIGN KEY (endereco) REFERENCES endereco(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);
INSERT INTO aluno VALUES (default, "1.111.111","111.111.111-11","1234567",1,"1993-04-11",TRUE,"Mariazinha");
INSERT INTO aluno VALUES (default, "2.222.222","222.222.222-22","2345678",2,"1993-04-05",TRUE,"Joaozinho");
INSERT INTO aluno VALUES (default, "3.333.333","333.333.333-33","3456789",3,"1995-11-12",TRUE,"Zézinho");

CREATE TABLE IF NOT EXISTS responsavel(
	id serial PRIMARY KEY,
	nome text NOT NULL,
	tipo integer NOT NULL,
	aluno integer NOT NULL,
	
	FOREIGN KEY (tipo) REFERENCES tipo(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY (aluno) REFERENCES aluno(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);
INSERT INTO responsavel VALUES (default, "Saletinha",4,1);
INSERT INTO responsavel VALUES (default, "Maria do Rosário",4,2);
INSERT INTO responsavel VALUES (default, "Maria do Bairro",4,3);

CREATE TABLE IF NOT EXISTS contato(
	id serial PRIMARY KEY,
	tipo integer NOT NULL,
	aluno integer NOT NULL,
	valor varchar(100) NOT NULL,
	
	FOREIGN KEY (tipo) REFERENCES tipo(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY (aluno) REFERENCES aluno(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);
INSERT INTO contato VALUES (default, 6, 1,"mariazinha@outlook.com");
INSERT INTO contato VALUES (default,7, 1,"(49) 9999-1256");
INSERT INTO contato VALUES (default,6, 2,"joaozinho@yahoo.com.br");
INSERT INTO contato VALUES (default,7, 2,"(49) 8425-6987");
INSERT INTO contato VALUES (default,6, 3,"zezinho@gmail.com");
INSERT INTO contato VALUES (default,7, 3,"(49)9822-6987");

/* * DADOS PARA ESTOQUE E REFEIÇÕES */
CREATE TABLE IF NOT EXISTS unidadeMedida(
	id serial PRIMARY KEY,
	nome text NOT NULL,
	sigla varchar(5) UNIQUE NOT NULL
);
INSERT INTO unidadeMedida VALUES(default, 'Grama', 'g');
INSERT INTO unidadeMedida VALUES(default, 'Quilograma', 'Kg');
INSERT INTO unidadeMedida VALUES(default, 'Mililitro', 'ml');
INSERT INTO unidadeMedida VALUES(default, 'Litro', 'L');
INSERT INTO unidadeMedida VALUES(default, 'Unidade', 'uni');

CREATE TABLE IF NOT EXISTS ingrediente(
	id serial PRIMARY KEY,
	nome text NOT NULL,
	unidadeMedida integer NOT NULL,
	
	FOREIGN KEY (unidadeMedida) REFERENCES tipo(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);
INSERT INTO ingrediente VALUES (default, "Leite in natura", 4);
INSERT INTO ingrediente VALUES (default, "Maçã",2);
INSERT INTO ingrediente VALUES (default, "Biscoito salgado integral",2);
INSERT INTO ingrediente VALUES (default, "Mel de abelhas",2);

CREATE TABLE IF NOT EXISTS prato(
	id serial PRIMARY KEY,
	nome text NOT NULL
);
INSERT INTO prato VALUES (default, 'Leite, biscoito salgado integral, mel e uma maçã');

CREATE TABLE IF NOT EXISTS ingredientePrato(
	id serial PRIMARY KEY,
	ingrediente integer NOT NULL,
	prato integer NOT NULL,
	quantidade float NOT NULL,
	
	FOREIGN KEY (ingrediente) REFERENCES ingrediente(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY (prato) REFERENCES prato(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);
INSERT INTO ingredientePrato VALUES (default, 1,1,25);
INSERT INTO ingredientePrato VALUES (default, 2,1,10);
INSERT INTO ingredientePrato VALUES (default, 3,1,5.95);
INSERT INTO ingredientePrato VALUES (default, 4,1,1.5);

CREATE TABLE IF NOT EXISTS cardapioDiario(
	id serial PRIMARY KEY,
	dia date NOT NULL
);
INSERT INTO cardapioDiario VALUES (default, '2015-08-21');

CREATE TABLE IF NOT EXISTS pratoCarDiario(
	id serial PRIMARY KEY,
	cardapio integer NOT NULL,
	prato integer NOT NULL,
	turno integer NOT NULL,
	
	FOREIGN KEY (cardapio) REFERENCES cardapioDiario(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY (prato) REFERENCES prato(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY (turno) REFERENCES tipo(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);
INSERT INTO pratoCarDiario VALUES (default, 1,1,9);


CREATE TABLE IF NOT EXISTS refeicao(
	id serial PRIMARY KEY,
	aluno integer NOT NULL,
	pratoCarDiario integer NOT NULL,
	ingredientePrato integer NOT NULL,
	dataHora timestamp NOT NULL DEFAULT now(0),
	
	FOREIGN KEY (aluno) REFERENCES aluno(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY (pratoCarDiario) REFERENCES pratoCarDiario(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE,
	FOREIGN KEY (ingredientePrato) REFERENCES ingredientePrato(id)
		ON DELETE RESTRICT
		ON UPDATE CASCADE
);
