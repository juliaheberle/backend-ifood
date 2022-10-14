package br.com.restaurante.ifood.model;

import br.com.restaurante.ifood.controller.dto.EnderecoDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties("endereco")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurante_id")
    @JsonIgnoreProperties("endereco")
    private Restaurante restaurante;


    public Endereco(EnderecoDto enderecoDto) {
        this.id = enderecoDto.getId();
        this.estado = enderecoDto.getEstado();
        this.cidade = enderecoDto.getCidade();
        this.rua = enderecoDto.getRua();
        this.numero = enderecoDto.getNumero();
        this.cep = enderecoDto.getCep();
    }

    public static List<Endereco> converter(List<EnderecoDto> endereco) {
        return endereco.stream().map(Endereco::new).collect(Collectors.toList());
    }
}
