package io.allancordeiro.controleorcamento.transacoes.services;

import io.allancordeiro.controleorcamento.transacoes.dto.SummaryDTO;
import io.allancordeiro.controleorcamento.transacoes.entities.Transacao;
import io.allancordeiro.controleorcamento.transacoes.enums.TipoOrcamento;
import io.allancordeiro.controleorcamento.transacoes.repositories.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SummaryService {
    private final TransacaoRepository transacaoRepository;
    private final SummaryDTO summary;

    public SummaryDTO summaryByPeriod(String year, String month) {
        ArrayList<Transacao> data = transacaoRepository.findByPeriod(year, month);
        Float totalDespesas = this.groupByType(data, TipoOrcamento.DESPESA);
        Float totalReceitas = this.groupByType(data, TipoOrcamento.RECEITA);
        summary.setTotalDespesas(totalDespesas);
        summary.setTotalReceitas(totalReceitas);
        summary.setMontlhyBalance(totalReceitas - totalDespesas);

        return summary;
    }

    private Float groupByType(ArrayList<Transacao> data, TipoOrcamento tipo) {
        return data.stream()
                .filter((fo) -> tipo.equals(fo.getTipoOrcamento()))
                .reduce(0.0f, (total, fo) -> total + fo.getValor(), Float::sum);
    }

}
