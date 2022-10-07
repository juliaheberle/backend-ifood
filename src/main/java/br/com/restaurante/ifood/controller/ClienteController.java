package br.com.restaurante.ifood.controller;

import br.com.restaurante.ifood.controller.dto.ClienteDto;
import br.com.restaurante.ifood.controller.dto.PedidoDto;
import br.com.restaurante.ifood.controller.dto.RestauranteDto;
import br.com.restaurante.ifood.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    private ResponseEntity<ClienteDto> post(@RequestBody ClienteDto clienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.post(clienteDto));
    }

    @PostMapping("/pedidos/{clienteId}")
    private ResponseEntity<List<PedidoDto>> casdastrarPedido(@PathVariable Long clienteId, @RequestBody List<PedidoDto> pedidoDto){
        return ResponseEntity.ok(clienteService.postPedido(clienteId, pedidoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getbyId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getBy(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll(){
        return ResponseEntity.ok(clienteService.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }

    @PutMapping
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto clienteDto){
        return ResponseEntity.ok(clienteService.update(clienteDto));
    }
}
