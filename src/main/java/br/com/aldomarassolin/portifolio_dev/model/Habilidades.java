package br.com.aldomarassolin.portifolio_dev.model;


import br.com.aldomarassolin.portifolio_dev.domain.habilidades.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "Habilidades")
@Table(name = "tb_habilidades")
public class Habilidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres")
    private String nome;

    @Embedded
    @Enumerated
    private Nivel nivel;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Habilidades(){}

    public Habilidades(Long id, String nome, Nivel nivel, Usuarios usuario) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres") String nome) {
        this.nome = nome;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
