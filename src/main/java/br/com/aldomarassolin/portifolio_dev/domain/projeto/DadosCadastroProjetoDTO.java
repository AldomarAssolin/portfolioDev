package br.com.aldomarassolin.portifolio_dev.domain.projeto;

import br.com.aldomarassolin.portifolio_dev.model.Usuarios;

import java.sql.Date;

public record DadosCadastroProjetoDTO(
        Long id,
        String nome,
        String descricao,
        String descricaoLonga,
        Date dataInicio,
        Date dataFim,
        String linkProjeto,
        String linkRepositorio,
        String linkDocumentacao,
        String imagemDestaque,
        String imagemThumb,
        String imagemGeral,
        Long usuarioId
) {
}
