package com.sheldon.readtransactionsbatch.writer;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import com.sheldon.readtransactionsbatch.mapper.TransacaoEntityMapper;
import com.sheldon.readtransactionsbatch.repository.TransacaoRepository;
import com.sheldon.readtransactionsbatch.repository.entity.TransacaoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LeituraArquivoLarguraFixaWriterConfig {

	private final TransacaoRepository transacaoRepository;

	@Bean
	public ItemWriter<TransacaoDTO> leituraArquivoLarguraFixaWriter() {
		return items -> {

			for (TransacaoDTO transacaoDTO : items) {

				TransacaoEntity transacaoEntity = TransacaoEntityMapper.INSTANCE.transacaoDTOToTransacaoEntity(transacaoDTO);
				transacaoRepository.save(transacaoEntity);
			}
		};
	}
}

