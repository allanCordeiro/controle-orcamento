package io.allancordeiro.controleorcamento.transacoes.repositories;

import io.allancordeiro.controleorcamento.transacoes.entities.Transacao;
import io.allancordeiro.controleorcamento.transacoes.enums.TipoOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.ArrayList;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    ArrayList<Transacao> findByDescricao(String descricao);
    ArrayList<Transacao> findByTipoOrcamento(TipoOrcamento tipoOrcamento);

    @Query(nativeQuery = true,
            value = "SELECT * FROM transacao WHERE EXTRACT(YEAR FROM data) = ?1"
                    + " AND EXTRACT(MONTH FROM data) = ?2")
    ArrayList<Transacao> findByPeriod(String year, String month);
}
