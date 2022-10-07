package br.com.restaurante.ifood.controller.dto;

import br.com.restaurante.ifood.model.Endereco;
import br.com.restaurante.ifood.model.Restaurante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RestauranteDto {
    private Long id;
    private List<Endereco> endereco;
    private String nome;
    private Long cnpj;
    private List<PratoDto> pratos;

    public RestauranteDto(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.endereco = restaurante.getEndereco();
        this.nome = restaurante.getNome();
        this.cnpj = restaurante.getCnpj();
        this.pratos = PratoDto.converterList(restaurante.getPratos());
    }

}
