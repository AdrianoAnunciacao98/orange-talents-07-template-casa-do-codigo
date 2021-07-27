package br.com.zupacademy.adriano.casadocodigo.controller.dto;

import br.com.zupacademy.adriano.casadocodigo.modelo.Autor;
import br.com.zupacademy.adriano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.adriano.casadocodigo.modelo.Livro;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Table(uniqueConstraints={@UniqueConstraint(columnNames={"titulo"})})
public class LivroDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String titulo;

    @NotBlank @Size(max=500)
    private String resumo;

    private String sumario;

    @Min(value=20)
    private Double preco;

     @Min(value=100)
    private Integer paginas;


    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;


    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;


    public LivroDto(@NotBlank String titulo,
                    @NotBlank @Size(max=500) String resumo,
                    String sumario,
                     @Min(value=20) Double preco,
                   @Min(value=100) Integer paginas,
                         @NotBlank @NotNull Categoria categoria, @NotBlank @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.categoria = categoria;
        this.autor = autor;
    }

    public LivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public LivroDto(){}

    public LivroDto(Long isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public Livro toModel(){
      return new Livro(this.titulo = titulo, this.resumo = resumo, this.sumario = sumario,
            this.preco = preco, this.paginas = paginas, this.categoria = categoria, this.autor = autor);

     }

     public static List<LivroDto> converter(List<Livro> livros){
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
     }


    }

