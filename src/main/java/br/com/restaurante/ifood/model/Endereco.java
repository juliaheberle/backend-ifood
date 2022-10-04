package br.com.restaurante.ifood.model;

import br.com.restaurante.ifood.controller.dto.EnderecoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String estado;
    private String cidade;
    private String rua;
    private Long numero;
    private Long cep;

    public Endereco(EnderecoDto enderecoDto) {
        this.id = enderecoDto.getId();
        this.estado = enderecoDto.getEstado();
        this.cidade = enderecoDto.getCidade();
        this.rua = enderecoDto.getRua();
        this.numero = enderecoDto.getNumero();
        this.cep = enderecoDto.getCep();
    }

}
