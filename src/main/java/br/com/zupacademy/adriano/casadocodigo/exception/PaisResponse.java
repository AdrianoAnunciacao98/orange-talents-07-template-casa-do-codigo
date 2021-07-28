package br.com.zupacademy.adriano.casadocodigo.exception;

import br.com.zupacademy.adriano.casadocodigo.modelo.Pais;
import org.springframework.stereotype.Component;

@Component
public class PaisResponse {

    private Pais pais;
    private String message;

    public PaisResponse(){}

    public PaisResponse(Pais pais, String message) {
        this.pais = pais;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
