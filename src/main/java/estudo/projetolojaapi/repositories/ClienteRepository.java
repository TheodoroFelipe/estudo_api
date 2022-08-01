package estudo.projetolojaapi.repositories;

import estudo.projetolojaapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}