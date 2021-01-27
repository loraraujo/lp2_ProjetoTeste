create database bdbiblioteca;
use bdbiblioteca;

create table categorias(
id serial not null primary key,
descricao varchar(50) not null);

create table tipos(
id serial not null primary key,
descricao varchar(50) not null);

create table obras(
id serial not null primary key,
descricao varchar(350) not null,
ano int not null,
autor varchar(150),
local varchar(50),
idcategoria int not null references categorias(id),
idtipo int not null references tipos(id));

create table emprestimos(
id serial not null primary key,
nome varchar(350) not null,
dataemprestimo datetime default now(),
datadevolucao datetime);