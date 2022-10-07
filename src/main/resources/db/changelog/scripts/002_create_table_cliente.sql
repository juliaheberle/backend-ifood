-- changeset jheberle:2
create table cliente (id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(255),
    data_nascimento date
);
-- rollback drop table cliente;
