package com.sheldon.readtransactionsbatch.step;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import com.sheldon.readtransactionsbatch.repository.transacoes.entity.TransacaoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ImportarTransacoesStepConfig {
	private final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step importarTransacoesStep(
			ItemReader lerTransacoes,
			FunctionItemProcessor<TransacaoDTO,TransacaoEntity> persistirTransacoes,
			ItemWriter<TransacaoEntity> printarTransacoes) {
		return stepBuilderFactory
				.get("importarTransacoesStep")
				.<TransacaoDTO, TransacaoDTO>chunk(1)
				.reader(lerTransacoes)
				.processor(persistirTransacoes)
				.writer(printarTransacoes)
				.build();
	}
}
