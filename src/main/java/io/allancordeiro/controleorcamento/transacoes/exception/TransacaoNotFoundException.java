package io.allancordeiro.controleorcamento.transacoes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransacaoNotFoundException extends Exception{
    public TransacaoNotFoundException(String descricao) {
        super("Transação [" + descricao + "] não encontrada(o).");
    }
}
