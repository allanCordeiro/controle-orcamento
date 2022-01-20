package io.allancordeiro.controleorcamento.transacoes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TransacaoRepeteadException extends Exception{
    public TransacaoRepeteadException(String descricao) {
        super("Transação de descrição [" + descricao + "] repetida no mesmo mês.");
    }
}

