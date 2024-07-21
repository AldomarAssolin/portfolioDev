package br.com.aldomarassolin.portifolio_dev.model;


import br.com.aldomarassolin.portifolio_dev.domain.usuario.DadosAtualizarUsuarioDTO;
import br.com.aldomarassolin.portifolio_dev.domain.usuario.DadosCadastroUsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity(name = "Usuarios")
@Table(name = "tb_usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Pattern(message = "Email deve ser válido", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$" )
    @Size(max = 100, message = "Email não pode ter mais de 100 caracteres")
    private String email;

    @Pattern(regexp = "\\d{10,15}")
    private String telefone;

    @Embedded
    private Endereco endereco;

    @Column(length = 1000)
    private String bio;

    @Column(length = 255)
    private String slug;

    @Column(length = 1000)
    private String historia;

    @Column(length = 1000)
    private String imagemPerfil;
    @Column(length = 1000)
    private String imagemProfissional;
    @Column(length = 1000)
    private String imagemPessoal;

    private boolean ativo;

    public Usuarios(){}

    public Usuarios(DadosCadastroUsuarioDTO dados) {

        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.bio = dados.bio();
        this.slug = dados.slug();
        this.historia = dados.historia();
        this.imagemPerfil = dados.imagemPerfil();
        this.imagemProfissional = dados.imagemProfissional();
        this.imagemPessoal = dados.imagemPessoal();
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

    public @NotBlank(message = "Email é obrigatório") @Pattern(message = "Email deve ser válido", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$") @Size(max = 100, message = "Email não pode ter mais de 100 caracteres") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") @Pattern(message = "Email deve ser válido", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$") @Size(max = 100, message = "Email não pode ter mais de 100 caracteres") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "\\d{10,15}") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Pattern(regexp = "\\d{10,15}") String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public @Size(max = 255, message = "Bio não pode ter mais de 255 caracteres") String getBio() {
        return bio;
    }

    public void setBio(@Size(max = 255, message = "Bio não pode ter mais de 255 caracteres") String bio) {
        this.bio = bio;
    }

    public @Size(max = 100, message = "Bio não pode ter mais de 100 caracteres") String getSlug() {
        return slug;
    }

    public void setSlug(@Size(max = 100, message = "Bio não pode ter mais de 100 caracteres") String slug) {
        this.slug = slug;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(@Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

    public @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String getImagemProfissional() {
        return imagemProfissional;
    }

    public void setImagemProfissional(@Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String imagemProfissional) {
        this.imagemProfissional = imagemProfissional;
    }

    public @Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String getImagemPessoal() {
        return imagemPessoal;
    }

    public void setImagemPessoal(@Size(max = 255, message = "Caminho da imagem não pode ter mais de 255 caracteres") String imagemPessoal) {
        this.imagemPessoal = imagemPessoal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void atualizarInformacoes(DadosAtualizarUsuarioDTO dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.email() != null){
            this.email = dados.email();
        }

        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

        if(dados.bio() != null){
            this.bio = dados.bio();
        }

        if(dados.slug() != null){
            this.slug = dados.slug();
        }

        if(dados.historia() != null){
            this.historia = dados.historia();
        }

        if(dados.imagemPerfil() != null){
            this.imagemPerfil = dados.imagemPerfil();
        }

        if(dados.imagemProfissional() != null){
            this.imagemProfissional = dados.imagemProfissional();
        }

        if(dados.imagemPessoal() != null){
            this.imagemPessoal = dados.imagemPessoal();
        }

    }

    public void excluirUsuario(){
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco.toString() +
                '}';
    }
}
