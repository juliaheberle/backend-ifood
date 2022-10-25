-- changeset jheberle:6
ALTER TABLE endereco ADD CONSTRAINT fk_endereco_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id);
-- rollback drop table cliente