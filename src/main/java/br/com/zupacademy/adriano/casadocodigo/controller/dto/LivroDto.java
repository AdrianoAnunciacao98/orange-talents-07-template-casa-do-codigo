package br.com.zupacademy.adriano.casadocodigo.controller.dto;

import br.com.zupacademy.adriano.casadocodigo.modelo.Autor;
import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.adriano.casadocodigo.modelo.Livro;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(uniqueConstraints={@UniqueConstraint(columnNames={"titulo"})})
public class LivroDto {

    @NotBlank
    @Column(unique = true, nullable = false)
    private String titulo;

    @NotBlank @Size(max=500)
    private String resumo;

    private String sumario;

    @NotBlank @Min(value=20)
    private Double preco;

     @Size(min=100)
    private Integer paginas;

    @NotBlank @NotNull
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @NotBlank @NotNull
    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;


    public LivroDto(@NotBlank String titulo,
                    @NotBlank @Size(max=500) String resumo,
                    String sumario,
                    @NotBlank @Min(value=20) Double preco,
                    @Size(min=100) Integer paginas,
                         @NotBlank @NotNull Categoria categoria, @NotBlank @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.categoria = categoria;
        this.autor = autor;
    }

    public LivroDto(){}

     public Livro toModel(){
      return new Livro(this.titulo = titulo, this.resumo = resumo, this.sumario = sumario,
            this.preco = preco, this.paginas = paginas, this.categoria = categoria, this.autor = autor);

     }
    }

