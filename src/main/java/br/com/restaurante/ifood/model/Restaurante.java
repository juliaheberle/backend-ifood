package br.com.restaurante.ifood.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Endereco endereco;
    private String nome;
    private Long cnpj;
    @OneToMany
    private List<Prato> pratos;
}
