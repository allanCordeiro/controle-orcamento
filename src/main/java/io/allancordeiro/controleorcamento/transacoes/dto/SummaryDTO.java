package io.allancordeiro.controleorcamento.transacoes.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDTO {
    private Float totalReceitas;
    private Float totalDespesas;
    private Float montlhyBalance;
    private ArrayList<CategoryBalanceDTO> categoryBalance;

}
