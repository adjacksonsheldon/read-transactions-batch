package com.sheldon.readtransactionsbatch.writer;

import com.sheldon.readtransactionsbatch.repository.transacoes.TransacaoRepository;
import com.sheldon.readtransactionsbatch.repository.transacoes.entity.TransacaoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PrintarTransacoesCadastradasWriterConfig {

	private final TransacaoRepository transacaoRepository;

	@Bean
	public ItemWriter<TransacaoEntity> printarTransacoesCadastradas() {
		return transacaoEntities -> transacaoEntities.forEach(System.out::println);
	}
}

