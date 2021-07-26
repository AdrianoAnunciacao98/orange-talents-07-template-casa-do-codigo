package br.com.zupacademy.adriano.casadocodigo.exception;

import br.com.zupacademy.adriano.casadocodigo.modelo.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorResponse {

    private Autor autor;
    private String message;

    public AutorResponse(Autor autor, String message) {
        this.autor = autor;
        this.message = message;
    }

    public AutorResponse(){}

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
