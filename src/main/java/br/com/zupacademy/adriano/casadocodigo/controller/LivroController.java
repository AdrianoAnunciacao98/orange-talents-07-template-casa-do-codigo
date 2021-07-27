package br.com.zupacademy.adriano.casadocodigo.controller;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.adriano.casadocodigo.exception.LivroResponse;
import br.com.zupacademy.adriano.casadocodigo.modelo.Livro;
import br.com.zupacademy.adriano.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}
