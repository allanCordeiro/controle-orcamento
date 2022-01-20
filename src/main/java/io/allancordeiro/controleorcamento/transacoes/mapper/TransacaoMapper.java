package io.allancordeiro.controleorcamento.transacoes.mapper;

import io.allancordeiro.controleorcamento.transacoes.dto.TransacaoDTO;
import io.allancordeiro.controleorcamento.transacoes.entities.Transacao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransacaoMapper {
    TransacaoMapper INSTANCE = Mappers.getMapper(TransacaoMapper.class);

    Transacao toEntity(TransacaoDTO transacaoDTO);
    TransacaoDTO toDTO(Transacao transacao);
}
