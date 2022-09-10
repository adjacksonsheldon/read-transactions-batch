package com.sheldon.readtransactionsbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    private final AppConfig appConfig;

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource springBatchDataSource(){
        return DataSourceBuilder.create()
                .url(appConfig.getJobDbUrl())
                .username(appConfig.getUsername())
                .password(appConfig.getPassword())
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "transactions.datasource")
    public DataSource transactionsBatchDataSource(){
        return DataSourceBuilder.create()
                .url(appConfig.getTransactionsDbUrl())
                .username(appConfig.getUsername())
                .password(appConfig.getPassword())
                .build();
    }
}
