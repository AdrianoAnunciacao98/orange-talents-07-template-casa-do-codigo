package br.com.zupacademy.adriano.casadocodigo.exception;

import br.com.zupacademy.adriano.casadocodigo.modelo.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroResponse {

    private Livro livro;
    private String message;

    public LivroResponse(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
