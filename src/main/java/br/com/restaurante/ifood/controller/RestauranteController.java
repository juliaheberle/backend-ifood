package br.com.restaurante.ifood.controller;

import br.com.restaurante.ifood.controller.dto.PratoDto;
import br.com.restaurante.ifood.controller.dto.RestauranteDto;
import br.com.restaurante.ifood.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<RestauranteDto> post(@RequestBody RestauranteDto restauranteDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteService.save(restauranteDto));
    }

    @PostMapping("{restauranteId}/prato")
    public ResponseEntity<PratoDto> postPrato(@PathVariable Long restauranteId, @RequestBody PratoDto pratoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteService.postPratos(restauranteId, pratoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDto> getBy(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDto>> getAll() {
        return ResponseEntity.ok(restauranteService.findAll());
    }

    @GetMapping("/pratos/{id}")
    public ResponseEntity<List<PratoDto>> getAllPratos(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteService.findAllPratos(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restauranteService.delete(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RestauranteDto> updatePartial(@PathVariable Long id, @RequestBody Map<String, String> changes) {
        return ResponseEntity.ok(restauranteService.updatePartial(id, changes));
    }

    @PutMapping
    public ResponseEntity<RestauranteDto> update(@RequestBody RestauranteDto restauranteDto) {
        return ResponseEntity.ok(restauranteService.update(restauranteDto));
    }


}
