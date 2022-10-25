-- changeset jheberle:5
create table pedido (id int PRIMARY KEY AUTO_INCREMENT,
    cliente_id int,
    valor_total float,
    endereco_entrega_id int,
    prazo_entrega date,
    auditoria varchar(255),
    CONSTRAINT fk_pedido_endereco_entrega FOREIGN KEY (endereco_entrega_id) REFERENCES endereco (id),
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);
-- rollback drop table pedido
