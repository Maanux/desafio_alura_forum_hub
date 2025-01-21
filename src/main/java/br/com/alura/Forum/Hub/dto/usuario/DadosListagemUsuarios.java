package br.com.alura.Forum.Hub.dto.usuario;

import br.com.alura.Forum.Hub.domain.usuario.Usuario;
import br.com.alura.Forum.Hub.dto.topicos.DadosListagemTopicos;

public record DadosListagemUsuarios(Long id, String nome, String email) {
    public DadosListagemUsuarios(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
