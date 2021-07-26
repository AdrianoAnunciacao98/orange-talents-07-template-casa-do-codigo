package br.com.zupacademy.adriano.casadocodigo.modelo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@Entity
    public class Autor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        private String nome;

        @Email @NotBlank
        private String email;

        @NotBlank
        @Size(max=400)
        private String descricao;

        private LocalDateTime instante = LocalDateTime.now();


        public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max=400) String descricao) {

            Assert.hasLength(nome, "O nome é obrigatório");
            this.nome = nome;
            this.email = email;
            this.descricao = descricao;
        }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
