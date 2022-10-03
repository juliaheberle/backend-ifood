package br.com.restaurante.ifood.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<Prato> pratos = new ArrayList<>();
    private Double valorTotal;
    @ManyToOne
    private Endereco enderecoEntrega;
    private LocalDate prazoEntrega;
    private String auditoria;

}
