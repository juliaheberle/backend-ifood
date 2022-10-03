-- changeset jheberle:1
alter table teste drop column nome;
-- rollback alter table teste add column nome varchar(255);

-- changeset jheberle:2
alter table teste add column nomex varchar(255);
-- rollback alter table teste drop column nomex;