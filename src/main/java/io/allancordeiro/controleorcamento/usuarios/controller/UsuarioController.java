package io.allancordeiro.controleorcamento.usuarios.controller;

import io.allancordeiro.controleorcamento.usuarios.dto.UsuarioDTO;
import io.allancordeiro.controleorcamento.usuarios.exceptions.UserNotFoundException;
import io.allancordeiro.controleorcamento.usuarios.services.UsuarioServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/usuario")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsuarioController {
    private final UsuarioServices usuarioServices;
    private final PasswordEncoder encoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO createUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        usuarioDTO.setPassword(encoder.encode(usuarioDTO.getPassword()));
        return usuarioServices.saveUsuario(usuarioDTO);
    }

}
