package br.com.aldomarassolin.portifolio_dev.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity(name = "Projetos")
@Table(name = "tb_projetos")
public class Projetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres")
    private String nome;

    @NotBlank(message = "Descrição é obrigatório")
    @Size(max = 255, message = "Descrição não pode ter mais de 100 caracteres")
    private String descricao;

    private String descricaoLonga;
    private Date dataInicio;
    private Date dataFim;
    private String linkProjeto;
    private String linkRepositorio;
    private String linkDocumentacao;
    private String imagemDestaque;
    private String imagemThumb;
    private String imagemGeral;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Projetos(){}

    public Projetos(Long id, String nome, String descricao, String descricaoLonga, Date dataInicio, Date dataFim, String linkProjeto, String linkRepositorio, String linkDocumentacao, String imagemDestaque, String imagemThumb, String imagemGeral, Usuarios usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.descricaoLonga = descricaoLonga;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.linkProjeto = linkProjeto;
        this.linkRepositorio = linkRepositorio;
        this.linkDocumentacao = linkDocumentacao;
        this.imagemDestaque = imagemDestaque;
        this.imagemThumb = imagemThumb;
        this.imagemGeral = imagemGeral;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório") @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Descrição é obrigatório") @Size(max = 255, message = "Descrição não pode ter mais de 100 caracteres") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "Descrição é obrigatório") @Size(max = 255, message = "Descrição não pode ter mais de 100 caracteres") String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoLonga() {
        return descricaoLonga;
    }

    public void setDescricaoLonga(String descricaoLonga) {
        this.descricaoLonga = descricaoLonga;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getLinkProjeto() {
        return linkProjeto;
    }

    public void setLinkProjeto(String linkProjeto) {
        this.linkProjeto = linkProjeto;
    }

    public String getLinkRepositorio() {
        return linkRepositorio;
    }

    public void setLinkRepositorio(String linkRepositorio) {
        this.linkRepositorio = linkRepositorio;
    }

    public String getLinkDocumentacao() {
        return linkDocumentacao;
    }

    public void setLinkDocumentacao(String linkDocumentacao) {
        this.linkDocumentacao = linkDocumentacao;
    }

    public String getImagemDestaque() {
        return imagemDestaque;
    }

    public void setImagemDestaque(String imagemDestaque) {
        this.imagemDestaque = imagemDestaque;
    }

    public String getImagemThumb() {
        return imagemThumb;
    }

    public void setImagemThumb(String imagemThumb) {
        this.imagemThumb = imagemThumb;
    }

    public String getImagemGeral() {
        return imagemGeral;
    }

    public void setImagemGeral(String imagemGeral) {
        this.imagemGeral = imagemGeral;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
