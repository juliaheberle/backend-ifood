package br.com.restaurante.ifood.service;

import br.com.restaurante.ifood.controller.dto.ClienteDto;
import br.com.restaurante.ifood.controller.dto.EnderecoDto;
import br.com.restaurante.ifood.controller.dto.PedidoDto;
import br.com.restaurante.ifood.controller.dto.PratoDto;
import br.com.restaurante.ifood.exception.BadRequestException;
import br.com.restaurante.ifood.model.Cliente;
import br.com.restaurante.ifood.model.Endereco;
import br.com.restaurante.ifood.model.Pedido;
import br.com.restaurante.ifood.model.Prato;
import br.com.restaurante.ifood.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PratoService pratoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private EnderecoService enderecoService;

    public ClienteDto post(ClienteDto clienteDto) {
        if (clienteDto.getId() == null) {
            Cliente cliente = clienteRepository.save(new Cliente(clienteDto));
            return new ClienteDto(cliente);
        } else {
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

    public PedidoDto postPedido(Long clienteId, List<PedidoDto> pedidoDto) {
        ClienteDto clienteDto = getBy(clienteId);
        clienteDto.setPedidos(Pedido.converter(pedidoDto));
        Double valor = .0;
        for (int i = 0; i < pedidoDto.size(); i++) {
            for (int j = 0; j < pedidoDto.get(i).getPratos().size(); j++) {
                PratoDto pratoDto = pratoService.getBy(pedidoDto.get(i).getPratos().get(j).getId());
                valor += pratoDto.getPreco();
            }
            pedidoDto.get(i).setValorTotal(valor);
        }

        ArrayList<Prato> listPrato = new ArrayList<>();
        pedidoDto.get(0).getPratos().forEach(item -> {
            Long pratoId = item.getId();
            PratoDto pratoDto = pratoService.getBy(pratoId);
            Prato prato = new Prato(pratoDto);
            listPrato.add(prato);
        });

        return pedidoService.post(
                PedidoDto.builder()
                        .cliente(new Cliente(clienteDto))
                        .prazoEntrega(LocalDate.now())
                        .pratos(listPrato)
                        .valorTotal(valor)
//                        .enderecoEntrega(clienteDto.getEndereco().get(0))
                        .build());
    }

    public EnderecoDto postEndereco(Long clienteId, List<EnderecoDto> enderecoDto) {
        ClienteDto clienteDto = getBy(clienteId);

        enderecoDto.get(0).setCliente(new Cliente(clienteDto));
        return enderecoService.post(enderecoDto.get(0));
    }

}
