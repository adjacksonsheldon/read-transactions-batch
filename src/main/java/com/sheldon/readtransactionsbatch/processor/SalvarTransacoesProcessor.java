package com.sheldon.readtransactionsbatch.processor;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import com.sheldon.readtransactionsbatch.mapper.TransacaoEntityMapper;
import com.sheldon.readtransactionsbatch.repository.transacoes.TransacaoRepository;
import com.sheldon.readtransactionsbatch.repository.transacoes.entity.TransacaoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SalvarTransacoesProcessor {
    private final TransacaoRepository transacaoRepository;

    @Bean
    public FunctionItemProcessor<TransacaoDTO, TransacaoEntity> salvarTransacoes() {
        return new FunctionItemProcessor<>(transacaoDTO -> {
            TransacaoEntity transacaoEntity = TransacaoEntityMapper.INSTANCE.transacaoDTOToTransacaoEntity(transacaoDTO);
            return transacaoRepository.save(transacaoEntity);
        });
    }
}
