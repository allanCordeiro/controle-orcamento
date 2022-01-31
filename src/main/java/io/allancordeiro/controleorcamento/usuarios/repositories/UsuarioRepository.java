package io.allancordeiro.controleorcamento.usuarios.repositories;

import io.allancordeiro.controleorcamento.usuarios.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);
}
