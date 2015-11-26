-- user: delgis
-- password: 12345

GRANT ALL ON ALL TABLES IN SCHEMA public TO delgis;

CREATE EXTENSION postgis;

CREATE TABLE bairro(
	id SERIAL,
	nome VARCHAR(255) NOT NULL
);

CREATE TABLE tipo_ocorrencia (
	id SERIAL,
	nome VARCHAR(255) NOT NULL
);

CREATE TABLE ocorrencia (
	id SERIAL,
	descricao VARCHAR(255) NOT NULL,
	id_tipo INTEGER
);

ALTER TABLE bairro ADD PRIMARY KEY(id);
ALTER TABLE tipo_ocorrencia ADD PRIMARY KEY(id);
ALTER TABLE ocorrencia ADD PRIMARY KEY(id);

ALTER TABLE ocorrencia ADD FOREIGN KEY (id_tipo) REFERENCES tipo_ocorrencia(id) ON DELETE CASCADE;

CREATE VIEW ocorrencias_por_bairro AS
SELECT nome, count(o.id) as qtd, st_askml(coordenadas) FROM bairro LEFT JOIN ocorrencia o ON st_within(o.coordenada, coordenadas) GROUP BY nome, coordenadas ORDER BY nome;

-- SIRGAS 2000 datum 4674
SELECT AddGeometryColumn ('public', 'bairro', 'coordenadas', 4674, 'POLYGON', 2);
SELECT AddGeometryColumn ('public', 'ocorrencia', 'coordenada', 4674, 'POINT', 2);

-- Quatro pontos pois o quarto e o primeiro
INSERT INTO bairro(nome, coordenadas) VALUES('abacate', st_geomfromtext(
	'POLYGON((6 15, 10 10, 20 10, 6 15))', 4674) );

-- Inserir tipo
INSERT INTO tipo_ocorrencia(id,nome) VALUES (0,'Roubo');
	
-- Inserir ponto
INSERT INTO ocorrencia (descricao, coordenada, id_tipo) VALUES ('Local 1', st_geomfromtext('POINT(10 20)', 4674), 0);

-- Traz a cordenada transformada
SELECT st_astext(coordenadas) FROM bairro;

-- Verifica interseção
SELECT nome, count(o.id), st_askml(coordenadas) FROM bairro LEFT JOIN ocorrencia o ON st_within(o.coordenada, coordenadas) GROUP BY nome, coordenadas ORDER BY nome;

