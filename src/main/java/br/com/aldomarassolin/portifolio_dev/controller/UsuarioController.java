package br.com.aldomarassolin.portifolio_dev.controller;


import br.com.aldomarassolin.portifolio_dev.domain.usuario.DadosAtualizarUsuarioDTO;
import br.com.aldomarassolin.portifolio_dev.domain.usuario.DadosCadastroUsuarioDTO;
import br.com.aldomarassolin.portifolio_dev.domain.usuario.DadosDetalheUsuarioDTO;
import br.com.aldomarassolin.portifolio_dev.domain.usuario.DadosListagemUsuarioDTO;
import br.com.aldomarassolin.portifolio_dev.model.Usuarios;
import br.com.aldomarassolin.portifolio_dev.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity createUsuario(@RequestBody @Valid DadosCadastroUsuarioDTO dados, UriComponentsBuilder uriBuilder){
        var createUsuario = new Usuarios(dados);
        usuarioRepository.save(createUsuario);

        var uri = uriBuilder.path("/api/usuarios/{id}").buildAndExpand(createUsuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalheUsuarioDTO(createUsuario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarioDTO>> getAllUsers(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page =  usuarioRepository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuarioDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarUsuario(@RequestBody @Valid DadosAtualizarUsuarioDTO usuarios){
        var usuario = usuarioRepository.getReferenceById(usuarios.id());
        usuario.atualizarInformacoes(usuarios);
        return ResponseEntity.ok(new DadosDetalheUsuarioDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.excluirUsuario();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharUsuario(@PathVariable Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalheUsuarioDTO(usuario));
    }

}
