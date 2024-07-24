package br.com.aldomarassolin.portifolio_dev.controller;

import br.com.aldomarassolin.portifolio_dev.domain.projeto.DadosCadastroProjetoDTO;
import br.com.aldomarassolin.portifolio_dev.domain.projeto.DadosDetalheProjetoDTO;
import br.com.aldomarassolin.portifolio_dev.model.Projetos;
import br.com.aldomarassolin.portifolio_dev.model.Usuarios;
import br.com.aldomarassolin.portifolio_dev.repository.ProjetoRepository;
import br.com.aldomarassolin.portifolio_dev.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity createProject(@RequestBody @Valid DadosCadastroProjetoDTO dados, UriComponentsBuilder uriBuilder){
        Usuarios usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Projetos projeto = new Projetos(dados, usuario);
        repository.save(projeto);

        var uri = uriBuilder.path("/api/projetos/{id}").buildAndExpand(projeto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalheProjetoDTO(projeto));
    }

}
