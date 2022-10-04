package br.com.restaurante.ifood.model;

import br.com.restaurante.ifood.controller.dto.RestauranteDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Endereco endereco;
    private String nome;
    private Long cnpj;
    @OneToMany(mappedBy = "restaurante")
    private List<Prato> pratos;

    public Restaurante(RestauranteDto restauranteDto, List<Prato> pratos) {
        this.id = restauranteDto.getId();
        this.endereco = restauranteDto.getEndereco();
        this.nome = restauranteDto.getNome();
        this.cnpj = restauranteDto.getCnpj();
        this.pratos = pratos;
    }
}
