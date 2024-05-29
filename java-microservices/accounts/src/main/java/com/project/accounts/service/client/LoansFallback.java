package com.project.accounts.service.client;

import com.project.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient{
    /**
     * @param mobileNumber
     * @param correlationId
     * @return
     */
    @Override
    public ResponseEntity<LoansDto> fetchLoansDetails(String mobileNumber, String correlationId) {
        return null;
    }
}
