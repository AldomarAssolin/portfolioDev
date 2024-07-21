package br.com.aldomarassolin.portifolio_dev.model;

import br.com.aldomarassolin.portifolio_dev.domain.usuario.DadosEndereco;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    String logradouro;
    String bairro;
    String cep;
    String cidade;
    String uf;
    String numero;
    String complemento;

    public Endereco() {
    }

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return uf;
    }

    public void setEstado(String estado) {
        this.uf = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void atualizarInformacoes(DadosEndereco dados){
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }

        if(dados.bairro() != null){
            this.bairro = dados.bairro();
        }

        if(dados.cep() != null){
            this.cep = dados.cep();
        }

        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }

        if(dados.uf() != null){
            this.uf = dados.uf();
        }

        if(dados.numero() != null){
            this.numero = dados.numero();
        }

        if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
