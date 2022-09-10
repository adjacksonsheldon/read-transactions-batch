package com.sheldon.readtransactionsbatch.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class ImportarTransacoesJob {

    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job importarTransacoes(Step importarTransacoesStep) {
        return jobBuilderFactory
                .get("importarTransacoes")
                .start(importarTransacoesStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
