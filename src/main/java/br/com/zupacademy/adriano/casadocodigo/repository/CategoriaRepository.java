package br.com.zupacademy.adriano.casadocodigo.repository;

import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    @Query("select c from Categoria c where c.nome like ?1")
    Optional<Categoria> findCategoriaByNome(String nome);

}
