package com.line.test.service;

import com.line.test.model.Card;
import com.line.test.model.CardUsageStatistics;
import com.line.test.model.CardVerificationResponse;
import com.line.test.repo.DummyCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardVerificationServiceImpl implements CardVerificationService {

    private final DummyCardRepo cardRepo;

    @Autowired
    public CardVerificationServiceImpl(DummyCardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    @Override
    public CardVerificationResponse verify(String cardNumber) {
        Optional<Card> card = cardRepo.getCard(cardNumber);
        return card.map(value -> new CardVerificationResponse(true, value)).
                orElseGet(() -> new CardVerificationResponse(false, null));
    }

    @Override
    public CardUsageStatistics getUsageStatistics(int start, int limit) {
        if(start< 1) return null;
        return cardRepo.getStat(start,limit);
    }
}
