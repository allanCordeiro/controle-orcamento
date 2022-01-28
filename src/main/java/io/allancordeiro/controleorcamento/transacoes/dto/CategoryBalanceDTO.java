package io.allancordeiro.controleorcamento.transacoes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.allancordeiro.controleorcamento.transacoes.enums.Categoria;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBalanceDTO {
    @JsonProperty("Categoria")
    private Categoria category;
    @JsonProperty("Valor Total")
    private Float totalValue;
}
