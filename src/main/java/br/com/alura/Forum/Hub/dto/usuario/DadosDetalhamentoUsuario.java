package br.com.alura.Forum.Hub.dto.usuario;

import br.com.alura.Forum.Hub.domain.usuario.Usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String email, String senha) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
