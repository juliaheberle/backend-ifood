package br.com.restaurante.ifood.controller.dto;

import br.com.restaurante.ifood.model.Prato;
import br.com.restaurante.ifood.model.Restaurante;
import br.com.restaurante.ifood.model.TipoComida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PratoDto {
    private Long id;
    private String titulo;
    private String descricao;
    private TipoComida tipoComida;
    private Restaurante restaurante;
    private Double preco;

    public PratoDto(Prato prato) {
        this.id = prato.getId();
        this.titulo = prato.getTitulo();
        this.descricao = prato.getDescricao();
        this.tipoComida = prato.getTipoComida();
        this.restaurante = prato.getRestaurante();
        this.preco = prato.getPreco();
    }

    public static List<PratoDto> converterList(List<Prato> pratos) {
        return pratos.stream().map(PratoDto::new).collect(Collectors.toList());
    }
}
