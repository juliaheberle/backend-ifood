-- changeset jheberle:8
ALTER TABLE prato ADD CONSTRAINT fk_pratos_pedidos FOREIGN KEY (pedido_id) REFERENCES pedido (id);
-- rollback drop table pedido