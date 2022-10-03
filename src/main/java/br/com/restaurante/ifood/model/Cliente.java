package br.com.restaurante.ifood.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    @OneToMany
    private List<Endereco> endereco = new ArrayList<>();
    @OneToMany
    private List<Pedido> pedidos;
}
