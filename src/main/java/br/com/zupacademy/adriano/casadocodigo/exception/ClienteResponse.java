package br.com.zupacademy.adriano.casadocodigo.exception;

import br.com.zupacademy.adriano.casadocodigo.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteResponse {

    private Cliente cliente;
    private String message;

    public ClienteResponse(){}

    public ClienteResponse(Cliente cliente, String message) {
        this.cliente = cliente;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
