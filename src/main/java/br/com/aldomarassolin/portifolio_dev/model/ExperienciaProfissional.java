package br.com.aldomarassolin.portifolio_dev.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity(name = "Experiencia_Profissional")
@Table(name = "tb_experiencias_profissonais")
public class ExperienciaProfissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Empresa é obrigatório")
    @Size(max = 255, message = "Bio não pode ter mais de 255 caracteres")
    private String empresa;

    @NotBlank(message = "Cargo é obrigatório")
    @Size(max = 100, message = "Cargo não pode ter mais de 100 caracteres")
    private String cargo;

    private Date dataInicio;

    private Date dataFim;

    private String descricao;

    @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres")
    private String imagemEmpresa;

    @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres")
    private String imagemServico;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public ExperienciaProfissional(){}

    public ExperienciaProfissional(Long id, String empresa, String cargo, Date dataInicio, Date dataFim, String descricao, String imagemEmpresa, String imagemServico, Usuarios usuario) {
        this.id = id;
        this.empresa = empresa;
        this.cargo = cargo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.imagemEmpresa = imagemEmpresa;
        this.imagemServico = imagemServico;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Empresa é obrigatório") @Size(max = 255, message = "Bio não pode ter mais de 255 caracteres") String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(@NotBlank(message = "Empresa é obrigatório") @Size(max = 255, message = "Bio não pode ter mais de 255 caracteres") String empresa) {
        this.empresa = empresa;
    }

    public @NotBlank(message = "Cargo é obrigatório") @Size(max = 100, message = "Cargo não pode ter mais de 100 caracteres") String getCargo() {
        return cargo;
    }

    public void setCargo(@NotBlank(message = "Cargo é obrigatório") @Size(max = 100, message = "Cargo não pode ter mais de 100 caracteres") String cargo) {
        this.cargo = cargo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String getImagemEmpresa() {
        return imagemEmpresa;
    }

    public void setImagemEmpresa(@Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String imagemEmpresa) {
        this.imagemEmpresa = imagemEmpresa;
    }

    public @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String getImagemServico() {
        return imagemServico;
    }

    public void setImagemServico(@Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String imagemServico) {
        this.imagemServico = imagemServico;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
