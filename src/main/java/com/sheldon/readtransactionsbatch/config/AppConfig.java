package com.sheldon.readtransactionsbatch.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AppConfig {
    @Value("${database-user}")
    private String username;

    @Value("${database-password}")
    private String password;

    @Value("${SPRING_BATCH_DB_URL}")
    private String springBatchDbUrl;

    @Value("${TRANSACTIONS_DB_URL}")
    private String transactionsDbUrl;
}
