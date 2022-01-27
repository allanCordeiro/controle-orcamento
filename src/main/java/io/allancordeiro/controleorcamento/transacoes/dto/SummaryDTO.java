package io.allancordeiro.controleorcamento.transacoes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDTO {
    @JsonProperty("Total receitas")
    private Float totalReceitas;
    @JsonProperty("Total despesas")
    private Float totalDespesas;
    @JsonProperty("Saldo final do mês")
    private BigDecimal montlhyBalance;
    @JsonProperty("Valor gasto por categoria")
    private ArrayList<CategoryBalanceDTO> categoryBalance;

}
