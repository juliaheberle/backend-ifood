package br.com.restaurante.ifood.controller.dto;

import br.com.restaurante.ifood.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
    private Long id;
    private String estado;
    private String cidade;
    private String rua;
    private Long numero;
    private Long cep;

    public EnderecoDto(Endereco endereco) {
        this.id = endereco.getId();
        this.estado = endereco.getEstado();
        this.cidade = endereco.getCidade();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cep = endereco.getCep();
    }
}
