package br.com.alura.Forum.Hub.repository;

import br.com.alura.Forum.Hub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
