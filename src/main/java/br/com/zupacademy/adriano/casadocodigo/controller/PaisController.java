package br.com.zupacademy.adriano.casadocodigo.controller;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.adriano.casadocodigo.controller.dto.PaisDto;
import br.com.zupacademy.adriano.casadocodigo.exception.PaisResponse;
import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.adriano.casadocodigo.modelo.Pais;
import br.com.zupacademy.adriano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private PaisResponse paisResponse;

    @PostMapping(value = "/paises")
    public ResponseEntity<Pais> cadastrar(@RequestBody @Valid PaisDto paisDto, BindingResult result){

        if (result.hasErrors()) {
            paisResponse.setMessage("Erro na aplicação devido a algum país errado." + result.getAllErrors());
            return new ResponseEntity(paisResponse, HttpStatus.BAD_REQUEST);
        } else {
            Pais pais = new Pais(paisDto.getNome());
            paisRepository.save(pais);
            paisResponse.setMessage("Sucesso, país cadastrado:");
            return new ResponseEntity(paisResponse, HttpStatus.OK);
        }

    }



}
