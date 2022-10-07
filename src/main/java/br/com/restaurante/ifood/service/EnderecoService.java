package br.com.restaurante.ifood.service;

import br.com.restaurante.ifood.controller.dto.ClienteDto;
import br.com.restaurante.ifood.controller.dto.EnderecoDto;
import br.com.restaurante.ifood.controller.dto.RestauranteDto;
import br.com.restaurante.ifood.exception.NotFoundException;
import br.com.restaurante.ifood.model.Endereco;
import br.com.restaurante.ifood.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private RestauranteService restauranteService;

    public ClienteDto saveCliente(List<EnderecoDto> enderecoDto, Long id) {
        ClienteDto clienteDto = clienteService.getBy(id);
        clienteDto.setEndereco(Endereco.converter(enderecoDto));
        return clienteDto;
    }

    public RestauranteDto saveRestaurante(List<EnderecoDto> enderecoDto, Long id) {
        RestauranteDto restauranteDto = restauranteService.findById(id);
//        Endereco endereco = new Endereco(enderecoDto);
        restauranteDto.setEndereco(Endereco.converter(enderecoDto));
        return restauranteDto;
    }

    public EnderecoDto getById(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Endereco nao existe!"));
        return new EnderecoDto(endereco);
    }

    public void deleteById(Long id) {
        try {
            enderecoRepository.deleteById(id);
        } catch (Exception exception) {
            new NotFoundException("Endereco ja deletado");
        }
    }

    public List<EnderecoDto> getAll() {
        return enderecoRepository.findAll()
                .stream()
                .map(EnderecoDto::new)
                .collect(Collectors.toList());
    }


//    public EnderecoDto uptadePartial(Long id, Map<String, String> changes) {
//        EnderecoDto endereco = getById(id);
//        changes.forEach((atributo, valor) -> {
//            switch (atributo) {
//                case "estado" : endereco.setEstado(valor);
//                case "cidade" : endereco.setCidade(valor);
//                case "rua" : endereco.setRua(valor);
//            }
//        });
//        return save(endereco);
//    }
}
