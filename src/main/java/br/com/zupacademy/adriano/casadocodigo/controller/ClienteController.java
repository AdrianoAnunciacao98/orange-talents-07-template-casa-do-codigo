package br.com.zupacademy.adriano.casadocodigo.controller;

import br.com.zupacademy.adriano.casadocodigo.controller.dto.ClienteDto;
import br.com.zupacademy.adriano.casadocodigo.exception.ClienteResponse;
import br.com.zupacademy.adriano.casadocodigo.modelo.Cliente;
import br.com.zupacademy.adriano.casadocodigo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClienteController {

    @Autowired
    ClienteResponse clienteResponse;
    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping(value="/clientes")
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid ClienteDto clienteDto, BindingResult result){
        if(result.hasErrors()){
            clienteResponse.setMessage("Erro ao cadastrar cliente" + result.getAllErrors());
            return new ResponseEntity(clienteResponse, HttpStatus.BAD_REQUEST);
        }
        else {
            Cliente cliente = new Cliente(clienteDto.getId());
            clienteRepository.save(cliente);
            clienteResponse.setMessage("Cliente Cadastrado com sucesso");
            return new ResponseEntity(clienteResponse, HttpStatus.OK);

        }
    }
}
