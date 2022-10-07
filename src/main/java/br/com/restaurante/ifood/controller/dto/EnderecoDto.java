package br.com.restaurante.ifood.controller.dto;

import br.com.restaurante.ifood.model.Cliente;
import br.com.restaurante.ifood.model.Endereco;
import br.com.restaurante.ifood.model.Restaurante;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
    private Cliente cliente;
    private Restaurante restaurante;

    public EnderecoDto(Endereco endereco) {
        this.id = endereco.getId();
        this.estado = endereco.getEstado();
        this.cidade = endereco.getCidade();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cep = endereco.getCep();
        this.cliente = endereco.getCliente();
        this.restaurante = endereco.getRestaurante();
    }

}
