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
    @Column(unique = true, nullable = false)
    private String nome;

    public Categoria( @NotBlank String nome) {
        this.nome = nome;
    }
}
