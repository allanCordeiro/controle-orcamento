package io.allancordeiro.controleorcamento.transacoes.services;

import io.allancordeiro.controleorcamento.transacoes.dto.CategoryBalanceDTO;
import io.allancordeiro.controleorcamento.transacoes.dto.SummaryDTO;
import io.allancordeiro.controleorcamento.transacoes.entities.Transacao;
import io.allancordeiro.controleorcamento.transacoes.enums.Categoria;
import io.allancordeiro.controleorcamento.transacoes.enums.TipoOrcamento;
import io.allancordeiro.controleorcamento.transacoes.repositories.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SummaryService {
    private final TransacaoRepository transacaoRepository;


    public SummaryDTO summaryByPeriod(Integer year, Integer month) {
        SummaryDTO summary = new SummaryDTO();
        BigDecimal total;
        ArrayList<Transacao> data = transacaoRepository.findByPeriod(year, month);
        Float totalDespesas = this.groupByType(data, TipoOrcamento.DESPESA);
        Float totalReceitas = this.groupByType(data, TipoOrcamento.RECEITA);
        summary.setTotalDespesas(totalDespesas);
        summary.setTotalReceitas(totalReceitas);
        summary.setCategoryBalance(this.groupByCategory(data));
        total = new BigDecimal(totalReceitas - totalDespesas);
        summary.setMontlhyBalance(total.setScale(2, RoundingMode.HALF_UP));

        return summary;
    }

    private Float groupByType(ArrayList<Transacao> data, TipoOrcamento tipo) {
        return data.stream()
                .filter((fo) -> tipo.equals(fo.getTipoOrcamento()))
                .reduce(0.0f, (total, fo) -> total + fo.getValor(), Float::sum);
    }

    private ArrayList<CategoryBalanceDTO> groupByCategory(ArrayList<Transacao> data) {
        ArrayList<CategoryBalanceDTO> categoryList = new ArrayList<CategoryBalanceDTO>();
        for(Categoria categoria : Categoria.values()) {
            CategoryBalanceDTO balance = new CategoryBalanceDTO();
            balance.setCategory(categoria);
            balance.setTotalValue(
                    data.stream()
                    .filter((fo) -> categoria.equals(fo.getCategoria()))
                    .reduce(0.0f, (total, fo) -> total + fo.getValor(), Float::sum)
            );
            categoryList.add(balance);
        }
        return categoryList;
    }

}
