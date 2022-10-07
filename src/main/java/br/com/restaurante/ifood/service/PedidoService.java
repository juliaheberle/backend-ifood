package br.com.restaurante.ifood.service;

import br.com.restaurante.ifood.controller.dto.PedidoDto;
import br.com.restaurante.ifood.model.Pedido;
import br.com.restaurante.ifood.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public PedidoDto post(PedidoDto pedidoDto) {
        Pedido pedido = pedidoRepository.save(new Pedido(pedidoDto));
        return new PedidoDto(pedido);
    }
}
