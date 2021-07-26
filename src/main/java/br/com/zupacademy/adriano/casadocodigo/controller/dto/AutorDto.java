package br.com.zupacademy.adriano.casadocodigo.controller.dto;

import br.com.zupacademy.adriano.casadocodigo.modelo.Autor;
import br.com.zupacademy.adriano.casadocodigo.repository.AutorRepository;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class AutorDto {
    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Size(max=400)
    private String descricao;




    public AutorDto(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max=400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }


    public Autor toModel(){
        return new Autor(this.nome,this.email,this.descricao);
     }

    public String getEmail() {
        return email;
    }
}
