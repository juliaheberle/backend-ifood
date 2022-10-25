-- changeset jheberle:3
create table restaurante (id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(255),
    cnpj int
);
-- rollback drop table restaurante;
