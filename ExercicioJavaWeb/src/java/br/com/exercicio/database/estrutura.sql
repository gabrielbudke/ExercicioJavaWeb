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
    media FLOAT,
    frequencia TINYINT,
    situacao VARCHAR(150));

INSERT INTO alunos (nome, codigo_matricula, nota_1, nota_2, nota_3, nota_4, media, frequencia, situacao) VALUE
('Madiaes', 7396602124, 10, 1, 4, 6, 5.25, 85, 'REPROVADO'), 
('Laneadar', 3961131278, 6, 10, 5, 6, 6.75, 70, 'EXAME'),
('Hanzgdub', 2479343079, 7, 10, 9, 8, 8.5, 85, 'APROVADO');