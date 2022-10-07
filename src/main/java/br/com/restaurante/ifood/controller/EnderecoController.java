package br.com.restaurante.ifood.controller;

import br.com.restaurante.ifood.controller.dto.ClienteDto;
import br.com.restaurante.ifood.controller.dto.EnderecoDto;
import br.com.restaurante.ifood.controller.dto.RestauranteDto;
import br.com.restaurante.ifood.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{id}/restaurante")
    private ResponseEntity<RestauranteDto> postEnderecoRestaurante(@RequestBody List<EnderecoDto> enderecoDto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.saveRestaurante(enderecoDto, id));
    }

    @PostMapping("{id}/cliente")
    private ResponseEntity<ClienteDto> postEnderecoCliente(@RequestBody List<EnderecoDto> enderecoDto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.saveCliente(enderecoDto, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> get(@PathVariable Long id){
        return ResponseEntity.ok(enderecoService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> getAll(){
        return ResponseEntity.ok(enderecoService.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        enderecoService.deleteById(id);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<EnderecoDto> uptadePartial(@PathVariable Long id, @RequestBody Map<String, String> changes){
//        return ResponseEntity.ok(enderecoService.uptadePartial(id, changes));
//    }
}
