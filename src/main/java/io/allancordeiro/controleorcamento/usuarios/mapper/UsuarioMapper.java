package io.allancordeiro.controleorcamento.usuarios.mapper;

import io.allancordeiro.controleorcamento.transacoes.dto.TransacaoDTO;
import io.allancordeiro.controleorcamento.transacoes.entities.Transacao;
import io.allancordeiro.controleorcamento.usuarios.dto.UsuarioDTO;
import io.allancordeiro.controleorcamento.usuarios.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toEntity(UsuarioDTO usuarioDTO);
    UsuarioDTO toDTO(Usuario usuario);
}
