package br.com.restaurante.ifood.service;

import br.com.restaurante.ifood.controller.dto.PratoDto;
import br.com.restaurante.ifood.controller.dto.RestauranteDto;
import br.com.restaurante.ifood.exception.BadRequestException;
import br.com.restaurante.ifood.exception.NotFoundException;
import br.com.restaurante.ifood.model.Prato;
import br.com.restaurante.ifood.model.Restaurante;
import br.com.restaurante.ifood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private PratoService pratoService;

    public RestauranteDto save(RestauranteDto restauranteDto) {
//        List<Prato> pratos = restauranteDto.getPratos()
//                .stream()
//                .map(Prato::new)
//                .collect(Collectors.toList());
        Restaurante restaurante = restauranteRepository.save(new Restaurante(restauranteDto));
        return new RestauranteDto(restaurante);
    }

    public RestauranteDto findById(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new NotFoundException("Restaurante nao cadastrado"));
        return new RestauranteDto(restaurante);
    }

    public List<RestauranteDto> findAll() {
        return restauranteRepository.findAll()
                .stream()
                .map(RestauranteDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        restauranteRepository.deleteById(id);
    }

    public RestauranteDto updatePartial(Long id, Map<String, String> changes) {
        RestauranteDto restaurante = findById(id);
        changes.forEach((atributo, valor) -> {
            switch (atributo) {
                case "nome":
                    restaurante.setNome(valor);
            }
        });

        return save(restaurante);
    }

    public RestauranteDto update(RestauranteDto restauranteDto) {
        Optional<Restaurante> byId = restauranteRepository.findById(restauranteDto.getId());
        if (byId.isPresent()) {
            return save(restauranteDto);
        }
        throw new BadRequestException("Para inserir um novo registro usar metodo post");

    }

    public List<PratoDto> findAllPratos(Long id) {
        RestauranteDto restauranteDto = findById(id);
        return PratoDto.converterList(restauranteDto.getPratos());
    }

    public PratoDto postPratos(Long restauranteId, PratoDto pratoDto) {
        RestauranteDto restauranteDto = findById(restauranteId);
        ArrayList<PratoDto> pratos = new ArrayList<>();
        pratos.add(pratoDto);
        restauranteDto.setPratos(Prato.converterList(pratos));
        pratoDto.setRestaurante(new Restaurante(restauranteDto));

        return pratoService.post(pratoDto);

    }
}
