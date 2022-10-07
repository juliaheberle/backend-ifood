package br.com.restaurante.ifood.model;

import br.com.restaurante.ifood.controller.dto.ClienteDto;
import br.com.restaurante.ifood.controller.dto.EnderecoDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "cliente")
@NoArgsConstructor
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cliente_id")
    @JsonIgnoreProperties("cliente")
    private List<Endereco> endereco;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="cliente_id")
    @JsonIgnoreProperties("cliente")
    private List<Pedido> pedidos;

    public Cliente(ClienteDto clienteDto) {
        this.id = clienteDto.getId();
        this.nome = clienteDto.getNome();
        this.dataNascimento = clienteDto.getDataNascimento();
        this.pedidos = clienteDto.getPedidos();
        this.endereco = clienteDto.getEndereco();
    }
}
