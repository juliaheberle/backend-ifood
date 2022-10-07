package br.com.restaurante.ifood.controller;

import br.com.restaurante.ifood.controller.dto.PratoDto;
import br.com.restaurante.ifood.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prato")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @PostMapping
    public ResponseEntity<PratoDto> post(@RequestBody PratoDto pratoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pratoService.post(pratoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PratoDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pratoService.getBy(id));
    }

    @GetMapping
    public ResponseEntity<List<PratoDto>> getAll() {
        return ResponseEntity.ok(pratoService.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        pratoService.delete(id);
    }
}
