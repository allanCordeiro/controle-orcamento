package io.allancordeiro.controleorcamento.transacoes.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.allancordeiro.controleorcamento.transacoes.enums.Categoria;
import io.allancordeiro.controleorcamento.transacoes.enums.TipoOrcamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transacao")
public class TransacaoDTO {
    private Long id;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private TipoOrcamento tipoOrcamento;

    @NotNull
    @NotBlank
    @Size(max=200)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @NotNull
    @PositiveOrZero
    private Float valor;

    @NotNull
    private LocalDate data;

}
