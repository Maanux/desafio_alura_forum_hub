package br.com.alura.Forum.Hub.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(

        @NotNull
        String nome,
        @NotNull
        @Email
        String email,
        @NotNull
        String senha
) {
}
