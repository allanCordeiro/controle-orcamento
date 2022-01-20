package io.allancordeiro.controleorcamento.transacoes.entities;

import io.allancordeiro.controleorcamento.transacoes.enums.TipoOrcamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tipo_orcamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoOrcamento tipoOrcamento;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private LocalDate data;

    @Column(name="created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name="updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
}
