package br.com.alura.Forum.Hub.dto.topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        String curso,
        Long autorId
) {
}
