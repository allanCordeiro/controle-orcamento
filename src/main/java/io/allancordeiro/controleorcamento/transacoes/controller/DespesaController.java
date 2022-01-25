package io.allancordeiro.controleorcamento.transacoes.controller;

import io.allancordeiro.controleorcamento.transacoes.dto.TransacaoDTO;
import io.allancordeiro.controleorcamento.transacoes.enums.Categoria;
import io.allancordeiro.controleorcamento.transacoes.enums.TipoOrcamento;
import io.allancordeiro.controleorcamento.transacoes.exception.TransacaoNotFoundException;
import io.allancordeiro.controleorcamento.transacoes.exception.TransacaoRepeteadException;
import io.allancordeiro.controleorcamento.transacoes.services.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/despesas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DespesaController {
    private final TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO createDespesa(@RequestBody @Valid TransacaoDTO transacaoDTO) throws TransacaoRepeteadException {
        transacaoDTO.setTipoOrcamento(TipoOrcamento.DESPESA);
        if(transacaoDTO.getCategoria() == null) {
            transacaoDTO.setCategoria(Categoria.OUTRAS);
        }
        return transacaoService.saveTransacao(transacaoDTO);
    }

    @GetMapping
    public List<TransacaoDTO> listDespesas() {
        return transacaoService.listAll(TipoOrcamento.DESPESA);
    }

    @GetMapping("/{id}")
    public TransacaoDTO getDespesa(@PathVariable Long id) throws TransacaoNotFoundException {
        return transacaoService.findById(id, TipoOrcamento.DESPESA);
    }

    @PutMapping("/{id}")
    public TransacaoDTO updateDespesa(@PathVariable Long id,
                                      @Valid @RequestBody TransacaoDTO transUpdated)
            throws TransacaoNotFoundException, TransacaoRepeteadException {
        TransacaoDTO transacao = transacaoService.findById(id, TipoOrcamento.DESPESA) ;
        transacao.setDescricao(transUpdated.getDescricao());
        transacao.setValor(transUpdated.getValor());
        transacao.setData(transUpdated.getData());
        if (transUpdated.getCategoria() == null) {
            transacao.setCategoria(Categoria.OUTRAS);
        } else {
            transacao.setCategoria(transUpdated.getCategoria());
        }

        return transacaoService.saveTransacao(transacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDespesa(@PathVariable Long id) throws TransacaoNotFoundException {
        transacaoService.deleteById(id, TipoOrcamento.DESPESA);
    }
}
