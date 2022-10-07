package br.com.restaurante.ifood.model;

import br.com.restaurante.ifood.controller.dto.PedidoDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties("pedidos")
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    private List<Prato> pratos;
    private BigDecimal valorTotal;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco enderecoEntrega;
    private LocalDate prazoEntrega;
    private String auditoria;

    public Pedido(PedidoDto pedido) {
        this.id = pedido.getId();
        this.cliente = pedido.getCliente();
        this.pratos = pedido.getPratos();
        this.valorTotal = pedido.getValorTotal();
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        this.prazoEntrega = pedido.getPrazoEntrega();
        this.auditoria = pedido.getAuditoria();
    }

    public static List<Pedido> converter(List<PedidoDto> pedidoDto) {
        return pedidoDto.stream().map(Pedido::new).collect(Collectors.toList());
    }
}
