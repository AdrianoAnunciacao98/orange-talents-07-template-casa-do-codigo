package br.com.zupacademy.adriano.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    //já adicionado anteriormente, serve para esse exercicio de validação dos campos.
    @Column(unique = true, nullable = false)
    private String nome;

    public Categoria(){}

    public Categoria( @NotBlank String nome) {
        this.nome = nome;
    }


}
