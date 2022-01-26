package io.allancordeiro.controleorcamento.transacoes.dto;

import io.allancordeiro.controleorcamento.transacoes.enums.Categoria;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBalanceDTO {
    private Categoria category;
    private Long totalValue;
}
