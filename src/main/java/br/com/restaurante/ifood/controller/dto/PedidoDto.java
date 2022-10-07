package br.com.restaurante.ifood.controller.dto;

import br.com.restaurante.ifood.model.Cliente;
import br.com.restaurante.ifood.model.Endereco;
import br.com.restaurante.ifood.model.Pedido;
import br.com.restaurante.ifood.model.Prato;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class PedidoDto {

    private Long id;
    private Cliente cliente;
    private List<Prato> pratos;
    private BigDecimal valorTotal;
    private Endereco enderecoEntrega;
    private LocalDate prazoEntrega;
    private String auditoria;

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = pedido.getCliente();
        this.pratos = pedido.getPratos();
        this.valorTotal = pedido.getValorTotal();
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        this.prazoEntrega = pedido.getPrazoEntrega();
        this.auditoria = pedido.getAuditoria();
    }

    public BigDecimal getValorTotalPedido(){
        Double precoTotal = .0;

        for(Prato item: pratos){
            precoTotal += item.getPreco();
        }

        return new BigDecimal(precoTotal);
    }
}