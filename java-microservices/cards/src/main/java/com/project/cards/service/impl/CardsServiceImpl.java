package com.project.cards.service.impl;

import com.project.cards.constants.CardsConstants;
import com.project.cards.dto.CardsDto;
import com.project.cards.entity.Cards;
import com.project.cards.exception.CardAlreadyExistsException;
import com.project.cards.exception.ResourceNotFoundException;
import com.project.cards.mapper.CardsMapper;
import com.project.cards.repository.CardsRepository;
import com.project.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {
    private CardsRepository cardsRepository;

    /**
     * @param mobileNumber - Mobile number of Customer
     */
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCards = cardsRepository.findByMobileNumber(mobileNumber);
          if(optionalCards.isPresent()) {
              // Throw an error
              throw new CardAlreadyExistsException("Card already registered with the given mobile number: " + mobileNumber);
          }
          cardsRepository.save(createNewCard(mobileNumber));
    }
    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return the new card details
     */
    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }
    /**
     * @param mobileNumber  - Mobile number of Customer
     * @return
     */

    @Override
    public CardsDto fetchCard(String mobileNumber) {
         Cards cards =  cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                // Throw an error!
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );

        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }

    /**
     * @param cardsDto - CardsDto Object
     * @return
     */
    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                // Throw an error
                () -> new ResourceNotFoundException("Card", "cardNumber", cardsDto.getCardNumber())
        );
        CardsMapper.mapToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return true;
    }

    /**
     * @param mobileNumber  - Mobile number of Customer
     * @return
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }
}
