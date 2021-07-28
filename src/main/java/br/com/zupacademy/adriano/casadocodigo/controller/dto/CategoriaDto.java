package br.com.zupacademy.adriano.casadocodigo.controller.dto;

import br.com.zupacademy.adriano.casadocodigo.modelo.Autor;
import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;


public class CategoriaDto {

    @NotBlank
    @Column(unique = true, nullable = false)
    private String nome;

    public CategoriaDto(@NotBlank String nome) {
        this.nome = nome;
    }

    public CategoriaDto(){}

    public Categoria toModel(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }


}
