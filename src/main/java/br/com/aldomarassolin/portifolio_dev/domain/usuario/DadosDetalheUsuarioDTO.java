package br.com.aldomarassolin.portifolio_dev.domain.usuario;

import br.com.aldomarassolin.portifolio_dev.model.Endereco;
import br.com.aldomarassolin.portifolio_dev.model.Usuarios;

public record DadosDetalheUsuarioDTO(
        String nome,
        String email,
        String telefone,
        Endereco endereco,
        String bio,
        String slug,
        String historia,
        String imagemPerfil,
        String imagemProfissional,
        String imagemPessoal
) {
    public DadosDetalheUsuarioDTO(Usuarios usuarios) {
        this(
                usuarios.getNome(),
                usuarios.getEmail(),
                usuarios.getTelefone(),
                usuarios.getEndereco(),
                usuarios.getBio(),
                usuarios.getSlug(),
                usuarios.getHistoria(),
                usuarios.getImagemPerfil(),
                usuarios.getImagemProfissional(),
                usuarios.getImagemPessoal()
        );
    }
}
