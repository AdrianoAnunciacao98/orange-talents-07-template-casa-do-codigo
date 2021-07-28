package br.com.zupacademy.adriano.casadocodigo.repository;

import br.com.zupacademy.adriano.casadocodigo.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long> {
}
