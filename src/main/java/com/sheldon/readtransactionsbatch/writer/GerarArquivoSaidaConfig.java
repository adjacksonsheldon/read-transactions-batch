package com.sheldon.readtransactionsbatch.writer;

import com.sheldon.readtransactionsbatch.dto.TransacaoDTO;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class GerarArquivoSaidaConfig {

    @StepScope
    @Bean
    public FlatFileItemWriter<TransacaoDTO> escritaArquivoSaidaWrite(@Value("#{jobParameters['arquivoSaida']}") Resource arquivoSaida){

        final String format = "%10s %10s";
        final String[] names = {"valor", "transacaoId"};

        return new FlatFileItemWriterBuilder<TransacaoDTO>()
                .name("escritaArquivoSaidaWrite")
                .resource(arquivoSaida)
                .formatted()
                .format(format)
                .names(names)
                .build();
    }
}
