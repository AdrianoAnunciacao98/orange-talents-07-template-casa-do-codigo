package br.com.zupacademy.adriano.casadocodigo.exception;

import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaResponse {

    private Categoria categoria;
    private String message;

    public CategoriaResponse(Categoria categoria, String message) {
        this.categoria = categoria;
        this.message = message;
    }

    public CategoriaResponse(){}

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
