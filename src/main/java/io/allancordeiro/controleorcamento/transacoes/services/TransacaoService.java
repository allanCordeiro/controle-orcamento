package io.allancordeiro.controleorcamento.transacoes.services;

import io.allancordeiro.controleorcamento.transacoes.dto.TransacaoDTO;
import io.allancordeiro.controleorcamento.transacoes.entities.Transacao;
import io.allancordeiro.controleorcamento.transacoes.enums.TipoOrcamento;
import io.allancordeiro.controleorcamento.transacoes.exception.TransacaoNotFoundException;
import io.allancordeiro.controleorcamento.transacoes.exception.TransacaoRepeteadException;
import io.allancordeiro.controleorcamento.transacoes.mapper.TransacaoMapper;
import io.allancordeiro.controleorcamento.transacoes.repositories.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper = TransacaoMapper.INSTANCE;

    public TransacaoDTO saveTransacao(TransacaoDTO transacaoDTO) throws TransacaoRepeteadException {
        Transacao transacao = transacaoMapper.toEntity(transacaoDTO);

        if (isDescriptionRepetead(transacao)) {
            throw new TransacaoRepeteadException(transacao.getDescricao());
        }
        Transacao savedTransacao = transacaoRepository.save(transacao);
        return transacaoMapper.toDTO(savedTransacao);
    }

    public List<TransacaoDTO> listAll(TipoOrcamento tipoOrcamento) {
        return transacaoRepository.findByTipoOrcamento(tipoOrcamento)
                .stream()
                .map(transacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TransacaoDTO> listByDescription(String description, TipoOrcamento tipo) {
        return transacaoRepository.findByDescricao(description)
                .stream()
                .filter((fo) -> tipo.equals(fo.getTipoOrcamento()))
                .map(transacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TransacaoDTO findById(Long id, TipoOrcamento tipoOrcamento) throws TransacaoNotFoundException {
        Transacao transacao = this.isTransacaoExists(id);
        if (this.isCorrectTipoOrcamento(transacao, tipoOrcamento)) {
            return transacaoMapper.toDTO(transacao);
        }
        throw new TransacaoNotFoundException("Transação + " + id + "não encontrada com tipo de orçamento " + tipoOrcamento);
    }

    public void deleteById(Long id, TipoOrcamento tipoOrcamento) throws TransacaoNotFoundException {
        Transacao transacao = this.isTransacaoExists(id);
        if (!this.isCorrectTipoOrcamento(transacao, tipoOrcamento)) {
            throw new TransacaoNotFoundException("Transação + " + id + "não encontrada com tipo de orçamento " + tipoOrcamento);
        }
        transacaoRepository.deleteById(id);
    }

    private Boolean isCorrectTipoOrcamento(Transacao transaco, TipoOrcamento tipoOrcamento) {
        if (transaco.getTipoOrcamento().equals(tipoOrcamento)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    private Transacao isTransacaoExists(Long id) throws TransacaoNotFoundException {
        return transacaoRepository.findById(id)
                .orElseThrow(() -> new TransacaoNotFoundException(id.toString()));
    }

    private Boolean isDescriptionRepetead(Transacao transToSearch) {
        Long id = transToSearch.getId();
        Month mes = transToSearch.getData().getMonth();
        Integer ano = transToSearch.getData().getYear();
        String descricao = transToSearch.getDescricao();
        TipoOrcamento tipo = transToSearch.getTipoOrcamento();

        ArrayList<Transacao> transacao = transacaoRepository.findByDescricao(descricao);
        if(transacao.isEmpty()) {
            return Boolean.FALSE;
        }
        Transacao existeOrcamento = transacao.stream()
                .filter((fo) ->
                        tipo.equals(fo.getTipoOrcamento()) &&
                        mes.equals(LocalDate.parse(fo.getData().toString()).getMonth()) &&
                        ano.equals(fo.getData().getYear())
                        )
                .findFirst()
                .orElse(null);

        if (existeOrcamento == null || id == existeOrcamento.getId()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
