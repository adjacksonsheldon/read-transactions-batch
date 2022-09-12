package com.sheldon.readtransactionsbatch.step;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GerarArquivoSaidaStepConfig {
	private final StepBuilderFactory stepBuilderFactory;

	@Bean
	@Qualifier("gerarArquivoSaidaStep")
	public Step gerarArquivoSaidaStep(
			ItemReader lerTransacoes,
			ItemWriter<TransacaoDTO> gerarArquivoSaida) {
		return stepBuilderFactory
				.get("gerarArquivoSaidaStep")
				.<TransacaoDTO, TransacaoDTO>chunk(1)
				.reader(lerTransacoes)
				.writer(gerarArquivoSaida)
				.build();
	}
}
