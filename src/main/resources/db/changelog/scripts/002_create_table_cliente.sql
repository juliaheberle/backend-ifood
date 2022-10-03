-- changeset jheberle:2
create table cliente (id int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(255),
    data_nascimento date,
    pedidos int,
    endereco_id int,
    CONSTRAINT fk_cliente_endereco FOREIGN KEY (endereco_id) REFERENCES endereco (id)
);
-- rollback drop table cliente;
