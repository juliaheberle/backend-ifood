package br.com.restaurante.ifood.model;

import br.com.restaurante.ifood.controller.dto.PratoDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "restaurante_id")
    @JsonIgnoreProperties("pratos")
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
