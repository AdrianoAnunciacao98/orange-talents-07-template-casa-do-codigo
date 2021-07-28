package br.com.zupacademy.adriano.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    public Pais(){}

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }


}
