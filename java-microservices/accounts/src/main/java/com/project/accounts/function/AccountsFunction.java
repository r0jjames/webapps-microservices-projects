package com.project.accounts.function;

import com.project.accounts.service.IAccountsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccountsFunction {
    private static final Logger logger = LoggerFactory.getLogger(AccountsFunction.class);

    @Bean
    public Consumer<Long> updateCommunication(IAccountsService accountsService) {
        return accountNumber -> {
            logger.info("Updating Communication Status for the account number: " + accountNumber.toString());
            accountsService.updateCommunicationStatus(accountNumber);
        };
    }
}
