-- changeset jheberle:1
create table endereco (id int PRIMARY KEY AUTO_INCREMENT,
    estado varchar(255),
    cidade varchar(255),
    rua varchar(255),
    numero int,
    cep int,
    cliente_id int,
    restaurante_id int
);
-- rollback drop table endereco;
