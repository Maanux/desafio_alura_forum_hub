package br.com.alura.Forum.Hub.dto.topicos;

import br.com.alura.Forum.Hub.domain.topico.Topico;
import lombok.extern.java.Log;

import java.time.LocalDateTime;

public record DadosListagemTopicos(Long id, String titulo, String mensagem, LocalDateTime data) {
    public DadosListagemTopicos(Topico topico) {
        this(topico.getId(),topico.getTitulo(),topico.getMensagem(),topico.getDataCriacao());
    }
}
