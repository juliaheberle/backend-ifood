package br.com.restaurante.ifood.service;

import br.com.restaurante.ifood.controller.dto.PratoDto;
import br.com.restaurante.ifood.exception.BadRequestException;
import br.com.restaurante.ifood.model.Prato;
import br.com.restaurante.ifood.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PratoService {
    
    @Autowired
    private PratoRepository pratoRepository;

    public PratoDto post(PratoDto pratoDto) {
        Prato prato = pratoRepository.save(new Prato(pratoDto));
        return new PratoDto(prato);
    }

    public PratoDto getBy(Long id) {
        Prato prato = pratoRepository.findById(id).orElseThrow(() -> new BadRequestException("Prato nao cadastrado"));
        return new PratoDto(prato);
    }

    public List<PratoDto> getAll() {
        List<Prato> pratos = pratoRepository.findAll();
        return pratos.stream()
                .map(PratoDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        pratoRepository.deleteById(id);
    }
}
