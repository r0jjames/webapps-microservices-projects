package com.project.accounts.service.client;

import com.project.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{
    /**
     * @param mobileNumber
     * @param correlationId
     * @return
     */
    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String mobileNumber, String correlationId) {
        return null;
    }
}
