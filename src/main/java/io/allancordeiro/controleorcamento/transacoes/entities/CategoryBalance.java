package io.allancordeiro.controleorcamento.transacoes.entities;

import io.allancordeiro.controleorcamento.transacoes.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBalance {
    private Categoria category;
    private Long totalValue;
}
