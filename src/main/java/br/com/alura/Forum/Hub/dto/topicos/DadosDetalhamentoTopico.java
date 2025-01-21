package br.com.alura.Forum.Hub.dto.topicos;

import br.com.alura.Forum.Hub.domain.topico.Cursos;
import br.com.alura.Forum.Hub.domain.topico.Topico;
import br.com.alura.Forum.Hub.domain.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Cursos curso, Usuario autor) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),topico.getCurso(), topico.getAutor());
    }
}
