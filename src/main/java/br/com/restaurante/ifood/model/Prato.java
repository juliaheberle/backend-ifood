package br.com.restaurante.ifood.model;

import br.com.restaurante.ifood.controller.dto.PratoDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;
    @ManyToOne
    private Restaurante restaurante;
    private Double preco;

    public Prato(PratoDto pratoDto) {
        this.id = pratoDto.getId();
        this.titulo = pratoDto.getTitulo();
        this.descricao = pratoDto.getDescricao();
        this.tipoComida = pratoDto.getTipoComida();
        this.restaurante = pratoDto.getRestaurante();
        this.preco = pratoDto.getPreco();
    }
}
