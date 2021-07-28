package br.com.zupacademy.adriano.casadocodigo.repository;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.adriano.casadocodigo.modelo.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findByTituloAndId(Long isbn, String Titulo);
}
