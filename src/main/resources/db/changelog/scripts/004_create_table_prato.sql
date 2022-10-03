-- chageset jheberle:4
create table prato (id int PRIMARY KEY AUTO_INCREMENT,
    titulo varchar(255),
    descricao varchar(255),
    preco float,
    tipo_comida varchar(255),
    restaurante_id int,
    CONSTRAINT fk_prato_restaurante FOREIGN KEY (restaurante_id) REFERENCES restaurante (id)

);
-- rollback drop table prato;
