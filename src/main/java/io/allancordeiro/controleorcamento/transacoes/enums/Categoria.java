package io.allancordeiro.controleorcamento.transacoes.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Categoria {
    ALIMENTACAO("Alimentação"),
    SAUDE("Saúde"),
    MORADIA("Moradia"),
    TRANSPORTE("Transporte"),
    EDUCACAO("Educação"),
    LAZER("Lazer"),
    IMPREVISTOS("Imprevistos"),
    OUTRAS("Outras"),
    @JsonProperty("''") EMPTY("");


    private final String descricao;

}
