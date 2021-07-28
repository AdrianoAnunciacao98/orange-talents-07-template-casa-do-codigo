package br.com.zupacademy.adriano.casadocodigo.exception;

import br.com.zupacademy.adriano.casadocodigo.modelo.Estado;
import org.springframework.stereotype.Component;

@Component
public class EstadoResponse {

    private Estado estado;
    private String message;

    public EstadoResponse(){}


    public EstadoResponse(Estado estado, String message) {
        this.estado = estado;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
