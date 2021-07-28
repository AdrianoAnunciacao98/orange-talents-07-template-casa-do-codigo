package br.com.zupacademy.adriano.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @Column(unique = true)
    private String documento;
    @NotBlank
    private String endereco;
    @NotNull
    private Integer complemento;
    @NotBlank
    private String cidade;
    @NotBlank @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public Cliente(){}

    public Cliente( @Email @NotBlank String email,@NotBlank String nome, @NotBlank String sobrenome,
                    @NotBlank  String documento,  @NotBlank String endereco,
                    @NotNull Integer complemento, @NotBlank String cidade,
                    @NotBlank  Pais pais,
                   Estado estado,  @NotBlank String telefone,  @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente(Long id) {
        this.id = id;
    }
}
