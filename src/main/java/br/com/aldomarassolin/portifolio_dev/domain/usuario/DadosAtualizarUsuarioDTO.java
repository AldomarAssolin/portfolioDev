package br.com.aldomarassolin.portifolio_dev.domain.usuario;

import br.com.aldomarassolin.portifolio_dev.model.Endereco;
import br.com.aldomarassolin.portifolio_dev.model.Usuarios;

public record DadosAtualizarUsuarioDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco,
        String bio,
        String slug,
        String historia,
        String imagemPerfil,
        String imagemProfissional,
        String imagemPessoal
) {
}
