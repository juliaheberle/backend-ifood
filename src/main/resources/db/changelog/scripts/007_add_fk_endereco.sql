-- changeset jheberle:7
ALTER TABLE endereco ADD CONSTRAINT fk_endereco_restaurante FOREIGN KEY (restaurante_id) REFERENCES restaurante (id);
-- rollback drop table restaurante