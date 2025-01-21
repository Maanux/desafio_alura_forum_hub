package br.com.alura.Forum.Hub.controller;

import br.com.alura.Forum.Hub.domain.usuario.Usuario;
import br.com.alura.Forum.Hub.dto.usuario.DadosCadastroUsuario;
import br.com.alura.Forum.Hub.dto.usuario.DadosDetalhamentoUsuario;
import br.com.alura.Forum.Hub.dto.usuario.DadosListagemUsuarios;
import br.com.alura.Forum.Hub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario (dados);
        Usuario usuarioSalvo = repository.save(new Usuario(dados));

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuarioSalvo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuarios>> mostrarUsuarios(@PageableDefault(size = 5, sort = "nome") Pageable paginacao) {
        var pagina = repository.findAll(paginacao).map(DadosListagemUsuarios:: new);

        return  ResponseEntity.ok(pagina);
    }


}
