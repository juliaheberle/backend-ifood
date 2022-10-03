package br.com.restaurante.ifood.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;
    @OneToOne
    private Restaurante restaurante;
    private Double preco;
}
