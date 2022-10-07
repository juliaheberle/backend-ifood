package br.com.restaurante.ifood.service;

import br.com.restaurante.ifood.controller.dto.ClienteDto;
import br.com.restaurante.ifood.controller.dto.PedidoDto;
import br.com.restaurante.ifood.exception.BadRequestException;
import br.com.restaurante.ifood.model.Cliente;
import br.com.restaurante.ifood.model.Pedido;
import br.com.restaurante.ifood.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDto post(ClienteDto clienteDto) {
        if (clienteDto.getId() == null){
            Cliente cliente = clienteRepository.save(new Cliente(clienteDto));
            return new ClienteDto(cliente);
        }else {
            throw new BadRequestException("Cliente ja cadastrado, para alterar registos use update");
        }
    }

    public ClienteDto getBy(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new BadRequestException(""));
        return new ClienteDto(cliente);
    }

    public List<ClienteDto> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDto.converter(clientes);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteDto update(ClienteDto clienteDto) {
        return post(clienteDto);
    }

    public List<PedidoDto> postPedido(Long clienteId, List<PedidoDto> pedidoDto) {
        ClienteDto clienteDto = getBy(clienteId);
        clienteDto.setPedidos(Pedido.converter(pedidoDto));
        pedidoDto.forEach(item -> {
            BigDecimal valorTotal = item.getValorTotalPedido();
            item.setValorTotal(valorTotal);
        });
        return pedidoDto;
    }
}
