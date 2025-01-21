package br.com.alura.Forum.Hub.controller;

import br.com.alura.Forum.Hub.domain.topico.Topico;
import br.com.alura.Forum.Hub.dto.topicos.DadosAtualizaTopico;
import br.com.alura.Forum.Hub.dto.topicos.DadosCadastroTopico;
import br.com.alura.Forum.Hub.dto.topicos.DadosDetalhamentoTopico;
import br.com.alura.Forum.Hub.dto.topicos.DadosListagemTopicos;
import br.com.alura.Forum.Hub.repository.TopicoRepository;
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
@RequestMapping("topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dados, usuarioRepository);
        Topico topicoSalvo = repository.save(new Topico(dados, usuarioRepository));
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topicoSalvo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> mostrarTopicos(@PageableDefault(size = 10, sort = "titulo")Pageable paginacao) {
        var pagina = repository.findAllByAtivoTrue(paginacao).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity acharTopicoPorId(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid DadosAtualizaTopico dados ) {
        var topico = repository.getReferenceById(dados.id());

        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        topico.deletar();

        return ResponseEntity.noContent().build();

    }

}


//@RestController
//@RequestMapping("medicos")
//@SecurityRequirement(name = "bearer-key")
//public class MedicoController {
//    @Autowired
//    private MedicoRepository repository;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
//        var medico = new Medico(dados);
//        Medico medicoSalvo = repository.save(new Medico(dados));
//
//        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medicoSalvo.getId()).toUri();
//
//        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medicoSalvo));
//    }
//
//    @GetMapping
//    public ResponseEntity <Page<DadosListagemMedico>> listarMedicos(@PageableDefault(size = 5, page = 0, sort = {"nome"}) Pageable paginacao) {
//
//        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
//        return ResponseEntity.ok(page);
//    }
//
//    @GetMapping("/inativos")
//    public ResponseEntity <Page<DadosListagemMedico>>listarMedicosInativos(@PageableDefault(size = 5, sort = {"nome"})Pageable paginacao) {
//        var page = repository.findAllByAtivoFalse(paginacao).map(DadosListagemMedico::new);
//        return ResponseEntity.ok(page);
//    }
//
//    @PutMapping
//    @Transactional
//    public ResponseEntity atualizarMedicos(@RequestBody @Valid DadosAtualizacaoMedico dados) {
//        var medico = repository.getReferenceById(dados.id());
//        medico.atualizarInformacoes(dados);
//        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity excluir(@PathVariable Long id) {
//        var medico = repository.getReferenceById(id);
//        medico.excluir();
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity detalhar(@PathVariable Long id) {
//        var medico = repository.getReferenceById(id);
//
//        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
//    }
//}