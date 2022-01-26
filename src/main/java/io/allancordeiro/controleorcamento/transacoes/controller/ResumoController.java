package io.allancordeiro.controleorcamento.transacoes.controller;

import io.allancordeiro.controleorcamento.transacoes.services.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/resumo")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ResumoController {
    private final TransacaoService transacaoService;

    @GetMapping("/{ano}/{mes}")
    public void getSummary() {

    }
}
