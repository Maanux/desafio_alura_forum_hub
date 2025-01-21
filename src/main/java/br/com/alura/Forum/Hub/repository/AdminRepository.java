package br.com.alura.Forum.Hub.repository;

import br.com.alura.Forum.Hub.domain.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    UserDetails findByLogin(String login);
}
