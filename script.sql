create table pessoa(
   id     uuid  primary key,
  nome   varchar(150)  not null,
  cpf     varchar(14)   not null,
  telefone varchar(20)   not null

);


select * from pessoa;


inser into pessoa(id,nome,cpf,telefone) values(gen_random_uuid(),'Ana Paula','123.545.789-00','(21 999999-0000');    );Total rows: 1 of 1
Query complete 00:00:00.372
