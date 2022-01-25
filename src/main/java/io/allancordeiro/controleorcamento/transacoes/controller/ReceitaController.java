package io.allancordeiro.controleorcamento.transacoes.controller;

import io.allancordeiro.controleorcamento.transacoes.dto.TransacaoDTO;
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
@RequestMapping("/api/v1/receitas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReceitaController {

    private final TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoDTO createReceita(@RequestBody @Valid TransacaoDTO transacaoDTO) throws TransacaoRepeteadException {
        transacaoDTO.setTipoOrcamento(TipoOrcamento.RECEITA);
        return transacaoService.saveTransacao(transacaoDTO);
    }

    @GetMapping
    public List<TransacaoDTO> listReceitas(
            @RequestParam(name="descricao", required=false) String description) {
        if(description != null && !description.isEmpty()) {
            return transacaoService.listByDescription(description, TipoOrcamento.RECEITA);
        }
        return transacaoService.listAll(TipoOrcamento.RECEITA);
    }


    @GetMapping("/{id}")
    public TransacaoDTO getReceita(@PathVariable Long id) throws TransacaoNotFoundException {
        return transacaoService.findById(id, TipoOrcamento.RECEITA);
    }

    @PutMapping("/{id}")
    public TransacaoDTO updateReceita(@PathVariable Long id,
                                        @Valid @RequestBody TransacaoDTO transUpdated)
            throws TransacaoNotFoundException, TransacaoRepeteadException {
        TransacaoDTO transacao = transacaoService.findById(id, TipoOrcamento.RECEITA) ;
        transacao.setDescricao(transUpdated.getDescricao());
        transacao.setValor(transUpdated.getValor());
        transacao.setData(transUpdated.getData());

        return transacaoService.saveTransacao(transacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReceita(@PathVariable Long id) throws TransacaoNotFoundException {
        transacaoService.deleteById(id, TipoOrcamento.RECEITA);
    }
}
