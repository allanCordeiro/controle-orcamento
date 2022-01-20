package io.allancordeiro.controleorcamento.transacoes.repositories;

import io.allancordeiro.controleorcamento.transacoes.entities.Transacao;
import io.allancordeiro.controleorcamento.transacoes.enums.TipoOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    ArrayList<Transacao> findByDescricao(String descricao);
    ArrayList<Transacao> findByTipoOrcamento(TipoOrcamento tipoOrcamento);
}
