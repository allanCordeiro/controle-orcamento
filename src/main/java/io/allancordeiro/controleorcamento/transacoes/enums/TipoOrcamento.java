package io.allancordeiro.controleorcamento.transacoes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoOrcamento {
    RECEITA("receita"),
    DESPESA("despesa");

    private final String tipo;

}
