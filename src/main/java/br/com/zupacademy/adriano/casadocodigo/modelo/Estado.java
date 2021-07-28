package br.com.zupacademy.adriano.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true)
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado(){}

    public Estado(@NotBlank  String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }


}
