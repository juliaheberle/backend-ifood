-- changeset jheberle:3
create table restaurante (id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(255),
    cnpj int,
    prato int,
    endereco_id int,
    CONSTRAINT fk_restaurante_endereco FOREIGN KEY (endereco_id) REFERENCES endereco (id)
);
-- rollback drop table restaurante;
