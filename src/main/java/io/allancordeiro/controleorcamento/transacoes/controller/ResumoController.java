package io.allancordeiro.controleorcamento.transacoes.controller;

import io.allancordeiro.controleorcamento.transacoes.dto.SummaryDTO;
import io.allancordeiro.controleorcamento.transacoes.services.SummaryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/resumo")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ResumoController {
    private final SummaryService summaryService;

    @GetMapping("/{ano}/{mes}")
    public SummaryDTO getSummary(@PathVariable String ano, @PathVariable String mes) {
        return summaryService.summaryByPeriod(ano, mes);
    }
}
