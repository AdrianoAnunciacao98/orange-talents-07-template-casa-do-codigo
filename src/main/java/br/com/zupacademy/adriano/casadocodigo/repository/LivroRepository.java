package br.com.zupacademy.adriano.casadocodigo.repository;

import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.adriano.casadocodigo.modelo.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    @Query("select l from Livro l where l.nome = ?1 and l.id where ?2")
    Optional<Livro> findLivrosByTituloAndId(Long id, String Titulo);
}
