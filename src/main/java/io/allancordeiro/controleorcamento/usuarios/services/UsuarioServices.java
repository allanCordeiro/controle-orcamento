package io.allancordeiro.controleorcamento.usuarios.services;

import io.allancordeiro.controleorcamento.usuarios.dto.UsuarioDTO;
import io.allancordeiro.controleorcamento.usuarios.entities.Usuario;
import io.allancordeiro.controleorcamento.usuarios.mapper.UsuarioMapper;
import io.allancordeiro.controleorcamento.usuarios.repositories.UsuarioRepository;
import io.allancordeiro.controleorcamento.usuarios.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public Optional<UsuarioDTO> getUsuario(String login) throws UserNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);

        return Optional.ofNullable(usuarioMapper.toDTO(usuario
                .orElseThrow(UserNotFoundException::new)));
    }
}
