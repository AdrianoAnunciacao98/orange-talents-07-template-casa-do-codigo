package br.com.zupacademy.adriano.casadocodigo.controller;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.adriano.casadocodigo.exception.CategoriaResponse;
import br.com.zupacademy.adriano.casadocodigo.modelo.Autor;
import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.adriano.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaResponse categoriaResponse;

    @PostMapping(value = "/categorias")
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaDto categoriaDto){
        Optional<Categoria> nome = categoriaRepository.findCategoriaByNome(categoriaDto.getNome());
        if (nome.isPresent()) {
            categoriaResponse.setMessage("Nome de categoria já existente");
            return new ResponseEntity(categoriaResponse, HttpStatus.BAD_REQUEST);
        } else {
            Categoria categoria = categoriaDto.toModel();
            categoriaRepository.save(categoria);
            categoriaResponse.setMessage("Sucesso, nome cadastrado: ");
            return new ResponseEntity(categoriaResponse, HttpStatus.OK);
        }

    }

}
