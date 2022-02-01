package io.allancordeiro.controleorcamento.usuarios.services;

import io.allancordeiro.controleorcamento.usuarios.entities.DetailUserData;
import io.allancordeiro.controleorcamento.usuarios.entities.Usuario;
import io.allancordeiro.controleorcamento.usuarios.mapper.UsuarioMapper;
import io.allancordeiro.controleorcamento.usuarios.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetailUserServiceImpl  implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    public DetailUserServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
        if(usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        }

        return new DetailUserData(usuarioMapper.toDTO(usuario.get()));
    }
}
