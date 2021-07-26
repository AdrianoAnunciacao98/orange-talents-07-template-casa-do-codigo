package br.com.zupacademy.adriano.casadocodigo.controller;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.adriano.casadocodigo.modelo.Autor;
import br.com.zupacademy.adriano.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/autores")
    public String cadastrar(@RequestBody @Valid AutorDto autorDto){
           Autor autor = autorDto.toModel();
            autorRepository.save(autor);
            return autor.toString();
        }

    }

