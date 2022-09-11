package com.sheldon.readtransactionsbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EntityScan(basePackages = {"com.sheldon.readtransactionsbatch.repository.transacoes.entity"})
@EnableJpaRepositories(basePackages = {"com.sheldon.readtransactionsbatch.repository.transacoes"})
public class TransactionsDataSourceConfig {

    private final AppConfig appConfig;

    @Bean("transactionsDataSource")
    @ConfigurationProperties(prefix = "transactions.datasource")
    public DataSource transactionsBatchDataSource(){
        return DataSourceBuilder.create()
                .url(appConfig.getTransactionsDbUrl())
                .username(appConfig.getUsername())
                .password(appConfig.getPassword())
                .build();
    }
}
