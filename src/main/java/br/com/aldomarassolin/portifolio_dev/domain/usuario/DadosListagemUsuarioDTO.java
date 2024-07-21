package br.com.aldomarassolin.portifolio_dev.domain.usuario;

import br.com.aldomarassolin.portifolio_dev.model.Endereco;
import br.com.aldomarassolin.portifolio_dev.model.Usuarios;

public record DadosListagemUsuarioDTO(
        Long id,
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


    public DadosListagemUsuarioDTO(Usuarios usuario){
        this(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getEndereco(),
                usuario.getBio(),
                usuario.getSlug(),
                usuario.getHistoria(),
                usuario.getImagemPerfil(),
                usuario.getImagemProfissional(),
                usuario.getImagemPessoal());
    }
}
