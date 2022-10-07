package br.com.restaurante.ifood.model;

import br.com.restaurante.ifood.controller.dto.RestauranteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="restaurante_id")
    private List<Endereco> endereco;
    private String nome;
    private Long cnpj;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "restaurante_id")
    @JsonIgnoreProperties("restaurante")
    private List<Prato> pratos;

    public Restaurante(RestauranteDto restauranteDto, List<Prato> pratos) {
        this.id = restauranteDto.getId();
        this.endereco = restauranteDto.getEndereco();
        this.nome = restauranteDto.getNome();
        this.cnpj = restauranteDto.getCnpj();
        this.pratos = pratos;
    }

}
