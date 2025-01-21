package br.com.alura.Forum.Hub.dto.topicos;

import br.com.alura.Forum.Hub.domain.topico.Cursos;
import br.com.alura.Forum.Hub.domain.usuario.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensagem,
        @NotNull
        @Future
        LocalDateTime datacriacao,
        @NotNull
        Cursos curso,
        @NotNull
        Long autorId

) {
}
