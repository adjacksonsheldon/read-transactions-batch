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

    @Value("${JOB_DB_URL}")
    private String jobDbUrl;

    @Value("${TRANSACTIONS_DB_URL}")
    private String transactionsDbUrl;
}
