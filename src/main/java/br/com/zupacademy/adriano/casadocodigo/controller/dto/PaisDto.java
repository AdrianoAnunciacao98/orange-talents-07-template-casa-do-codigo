package br.com.zupacademy.adriano.casadocodigo.controller.dto;

import br.com.zupacademy.adriano.casadocodigo.modelo.Pais;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

public class PaisDto {

    @NotBlank @Column(unique = true)
    private String nome;

    public PaisDto(){}

    public PaisDto(@NotBlank String nome) {
        this.nome = nome;
    }
    public Pais toModel(){
        return new Pais(this.nome = nome);
    }

    public String getNome() {
        return nome;
    }
}
