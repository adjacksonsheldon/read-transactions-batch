package com.sheldon.readtransactionsbatch.mapper;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import com.sheldon.readtransactionsbatch.repository.entity.TransacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransacaoEntityMapper {
    TransacaoEntityMapper INSTANCE = Mappers.getMapper( TransacaoEntityMapper.class );

    @Mapping(source = "id", target = "transacaoId")
    TransacaoEntity transacaoDTOToTransacaoEntity(TransacaoDTO transacaoDTO);
}
