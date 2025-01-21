package br.com.alura.Forum.Hub.domain.topico;

import br.com.alura.Forum.Hub.domain.usuario.Usuario;
import br.com.alura.Forum.Hub.dto.topicos.DadosAtualizaTopico;
import br.com.alura.Forum.Hub.dto.topicos.DadosCadastroTopico;
import br.com.alura.Forum.Hub.repository.UsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Column(name = "datacriacao")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Cursos curso;

    private Boolean ativo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autorid", nullable = false)
    private Usuario autor;

    public Topico(){}
    public Topico(@Valid DadosCadastroTopico dados, UsuarioRepository usuarioRepository) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.datacriacao();
        this.curso = dados.curso();
        this.ativo = true;
        this.autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + dados.autorId()));
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Cursos getCurso() {
        return curso;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void atualizarInformacoes(@Valid DadosAtualizaTopico dados) {
        if(dados.titulo() !=null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
    }

    public void deletar() {
        this.ativo = false;
    }
}



//package med.voll.api.domain.medico;
//
//import jakarta.persistence.*;
//        import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import med.voll.api.dto.medico.DadosAtualizacaoMedico;
//import med.voll.api.dto.medico.DadosCadastroMedico;
//import med.voll.api.domain.endereco.Endereco;
//
//@Table(name = "medicos")
//@Entity(name = "Medico")
//@Getter
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//public class Medico {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String nome;
//    private String email;
//    private String telefone;
//    private String crm;
//
//    @Enumerated(EnumType.STRING)
//    private  Especialidade especialidade;
//
//    @Embedded
//    private Endereco endereco;
//
//    private Boolean ativo;
//
//    public Medico() {}
//    public Medico(DadosCadastroMedico dados) {
//        this.ativo = true;
//        this.nome = dados.nome();
//        this.email = dados.email();
//        this.telefone = dados.telefone();
//        this.crm = dados.crm();
//        this.especialidade = dados.especialidade();
//        this.endereco = new Endereco(dados.endereco());
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public String getCrm() {
//        return crm;
//    }
//
//    public Especialidade getEspecialidade() {
//        return especialidade;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {
//        if (dados.nome() !=null) {
//            this.nome = dados.nome();
//        }
//        if (dados.telefone() != null) {
//            this.telefone = dados.telefone();
//        }
//        if (dados.endereco() != null) {
//            this.endereco.atualizarInformacoes(dados.endereco());
//        }
//    }
//
//    public void excluir() {
//        this.ativo = false;
//    }
//}
