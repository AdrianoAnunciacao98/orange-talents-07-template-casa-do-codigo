package br.com.zupacademy.adriano.casadocodigo.controller.dto;

import br.com.zupacademy.adriano.casadocodigo.modelo.Estado;
import br.com.zupacademy.adriano.casadocodigo.modelo.Pais;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class EstadoDto {

    @NotBlank @Column(unique = true)
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public EstadoDto(){}

    public EstadoDto(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado toModel(){
        return new Estado(this.nome = nome, this.pais = pais);
    }
}
