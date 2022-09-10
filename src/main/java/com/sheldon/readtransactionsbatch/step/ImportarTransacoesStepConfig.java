package com.sheldon.readtransactionsbatch.step;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ImportarTransacoesStepConfig {
	private final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step importarTransacoesStep(ItemReader<TransacaoDTO> lerTransacoes,
			ItemWriter<TransacaoDTO> salvarTransacoes) {
		return stepBuilderFactory
				.get("importarTransacoesStep")
				.<TransacaoDTO, TransacaoDTO>chunk(1)
				.reader(lerTransacoes)
				.writer(salvarTransacoes)
				.build();
	}
}
