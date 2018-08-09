DROP DATABASE IF EXISTS alunos_web;
CREATE DATABASE alunos_web;
USE alunos_web;

CREATE TABLE alunos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    codigo_matricula VARCHAR(10),
    nota_1 FLOAT,
    nota_2 FLOAT,
    nota_3 FLOAT,
    nota_4 FLOAT,
    frequencia TINYINT);
