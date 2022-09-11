package com.sheldon.readtransactionsbatch.mapper;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import com.sheldon.readtransactionsbatch.repository.transacoes.entity.TransacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransacaoEntityMapper {
    TransacaoEntityMapper INSTANCE = Mappers.getMapper( TransacaoEntityMapper.class );

    TransacaoEntity transacaoDTOToTransacaoEntity(TransacaoDTO transacaoDTO);
}
