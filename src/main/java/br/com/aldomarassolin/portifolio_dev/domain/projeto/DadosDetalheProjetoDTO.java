package br.com.aldomarassolin.portifolio_dev.domain.projeto;

import br.com.aldomarassolin.portifolio_dev.model.Projetos;
import br.com.aldomarassolin.portifolio_dev.model.Usuarios;

import java.sql.Date;

public record DadosDetalheProjetoDTO(
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
        String imagemGeral
) {
    public DadosDetalheProjetoDTO(Projetos projeto){
        this(
                projeto.getId(),
                projeto.getNome(),
                projeto.getDescricao(),
                projeto.getDescricaoLonga(),
                projeto.getDataInicio(),
                projeto.getDataFim(),
                projeto.getLinkProjeto(),
                projeto.getLinkRepositorio(),
                projeto.getLinkDocumentacao(),
                projeto.getImagemDestaque(),
                projeto.getImagemThumb(),
                projeto.getImagemGeral()
        );
    }
}
