package com.line.test.service;

import com.line.test.model.CardUsageStatistics;
import com.line.test.model.CardVerificationResponse;

import java.util.Optional;

public interface CardVerificationService {
    CardVerificationResponse verify(String cardNumber);

    CardUsageStatistics getUsageStatistics(int start, int limit);
}
