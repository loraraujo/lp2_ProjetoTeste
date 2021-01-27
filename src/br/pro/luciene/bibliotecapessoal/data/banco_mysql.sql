create database bdbiblioteca;
use bdbiblioteca;

create table categorias(
id int not null primary key auto_increment,
descricao varchar(50) not null);

create table tipos(
id int not null primary key auto_increment,
descricao varchar(50) not null);

create table obras(
id int not null primary key auto_increment,
descricao varchar(350) not null,
ano int not null,
autor varchar(150),
local varchar(50),
idcategoria int not null references categorias(id),
idtipo int not null references tipos(id));

create table emprestimos(
id int not null primary key auto_increment,
nome varchar(350) not null,
dataemprestimo datetime default now(),
datadevolucao datetime default now());