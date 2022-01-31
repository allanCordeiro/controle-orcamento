package io.allancordeiro.controleorcamento.usuarios.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Usuário ou senha inválidos.");
    }
}



