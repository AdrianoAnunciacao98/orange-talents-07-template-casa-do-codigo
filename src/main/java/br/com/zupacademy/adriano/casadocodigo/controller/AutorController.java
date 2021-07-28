package br.com.zupacademy.adriano.casadocodigo.controller;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.adriano.casadocodigo.exception.AutorResponse;
import br.com.zupacademy.adriano.casadocodigo.modelo.Autor;
import br.com.zupacademy.adriano.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private AutorResponse autorResponse;

    @PostMapping(value = "/autores")
    public ResponseEntity<Autor> cadastrar(@RequestBody @Valid AutorDto autorDto, BindingResult result) {
        Optional<Autor> email = autorRepository.findAutorByEmail(autorDto.getEmail());
        if (email.isPresent() || result.hasErrors()) {
          autorResponse.setMessage("E-mail requer que seja único ou erro no registro." + result);
            return new ResponseEntity(autorResponse, HttpStatus.BAD_REQUEST);
        } else {
            Autor autor = autorDto.toModel();
            autorRepository.save(autor);
            autorResponse.setMessage("Sucesso");
            return new ResponseEntity(autor.toString(), HttpStatus.OK);
        }

    } }


