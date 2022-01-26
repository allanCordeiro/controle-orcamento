package io.allancordeiro.controleorcamento.transacoes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Summary {
    private Float totalReceitas;
    private Float totalDespesas;
    private Float montlhyBalance;
}
