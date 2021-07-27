package br.com.zupacademy.adriano.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"titulo"})})
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    @NotBlank  @Column(unique = true, nullable = false)
    private String titulo;

    @NotBlank @Size(max=500)
    private String resumo;

    private String sumario;

    @NotBlank @Min(value=20)
    private Double preco;

     @Size(min=100)
    private Integer paginas;

   private Date data;

    @NotBlank @NotNull
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @NotBlank @NotNull
    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    public Livro(){}


    public Livro(@NotBlank String titulo, @NotBlank @Size(max=500) String resumo,
                 String sumario,  @NotBlank @Min(value=20) Double preco,
                 @Size(min=100) Integer paginas,
                 @NotBlank @NotNull Categoria categoria, @NotBlank @NotNull  Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.categoria = categoria;
        this.autor = autor;
    }




}
