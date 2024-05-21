package com.project.cards.service.client;

import com.project.cards.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cards")
public interface CardsFeignClient {

    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam String mobileNumber);
}
