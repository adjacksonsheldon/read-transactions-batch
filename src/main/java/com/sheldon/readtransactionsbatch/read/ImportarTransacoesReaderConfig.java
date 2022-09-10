package com.sheldon.readtransactionsbatch.read;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ImportarTransacoesReaderConfig {

	@StepScope
	@Bean
	public FlatFileItemReader<TransacaoDTO> importarTransacoesReader(
			@Value("#{jobParameters['arquivoClientes']}")Resource resource) {

		final Range[] ranges = {new Range(1, 10), new Range(11, 20)};
		final String[] names = {"id","valor"};

		return new FlatFileItemReaderBuilder<TransacaoDTO>()
				.name("importarTransacoesReader")
				.resource(resource)
				.fixedLength()
				.columns(ranges)
				.names(names)
				.targetType(TransacaoDTO.class)
				.build();
	}
}
