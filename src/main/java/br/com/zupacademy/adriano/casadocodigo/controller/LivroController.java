package br.com.zupacademy.adriano.casadocodigo.controller;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.adriano.casadocodigo.exception.LivroResponse;
import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.adriano.casadocodigo.modelo.Livro;
import br.com.zupacademy.adriano.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    LivroResponse livroResponse;

    @PostMapping(value = "/livros")
    public ResponseEntity<Livro> cadastrar(@RequestBody @Valid LivroDto livroDto, BindingResult result){
        if(result.hasErrors()){
         livroResponse.setMessage("Existem erros na validação" + result.getAllErrors());
         return new ResponseEntity(livroResponse, HttpStatus.BAD_REQUEST);
        }
        else {
            Livro livro = livroDto.toModel();
            livroRepository.save(livro);
            livroResponse.setMessage("Livro cadastrado com sucesso");
            return new ResponseEntity(livroResponse, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/livros")
    public List<LivroDto> listar(LivroDto livroDto){
        List<Livro> livros = livroRepository.findByTituloAndId(livroDto.getIsbn(), livroDto.getTitulo());
        return LivroDto.converter(livros);
        }
    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> detalhar(@PathVariable Long id, LivroDto livroDto){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            return ResponseEntity.ok(new LivroDto(livroDto.getTitulo(), livroDto.getResumo(),
            livroDto.getSumario(), livroDto.getPreco(),
                    livroDto.getPaginas(), livroDto.getCategoria(),livroDto.getAutor()));
        }
        return ResponseEntity.notFound().build();
    }


    }


