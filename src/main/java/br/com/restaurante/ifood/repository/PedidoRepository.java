package br.com.restaurante.ifood.repository;

import br.com.restaurante.ifood.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
