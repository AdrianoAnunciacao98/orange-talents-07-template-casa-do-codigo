package br.com.zupacademy.adriano.casadocodigo.controller;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.EstadoDto;
import br.com.zupacademy.adriano.casadocodigo.controller.dto.PaisDto;
import br.com.zupacademy.adriano.casadocodigo.exception.EstadoResponse;
import br.com.zupacademy.adriano.casadocodigo.modelo.Estado;
import br.com.zupacademy.adriano.casadocodigo.modelo.Pais;
import br.com.zupacademy.adriano.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoResponse estadoResponse;

    @PostMapping(value = "/estados")
    public ResponseEntity<Estado> cadastrar(@RequestBody @Valid EstadoDto estadoDto, BindingResult result){

        if (result.hasErrors()) {
            estadoResponse.setMessage("Erro na aplicação devido a algum estado errado, ou falta de país." + result.getAllErrors());
            return new ResponseEntity(estadoResponse, HttpStatus.BAD_REQUEST);
        } else {
            Estado estado = new Estado(estadoDto.getNome(), estadoDto.getPais());
            estadoRepository.save(estado);
            estadoResponse.setMessage("Sucesso, estado cadastrado:");
            return new ResponseEntity(estadoResponse, HttpStatus.OK);
        }

} }
