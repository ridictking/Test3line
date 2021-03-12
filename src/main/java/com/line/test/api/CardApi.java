package com.line.test.api;

import com.line.test.model.CardUsageStatistics;
import com.line.test.model.CardVerificationResponse;
import com.line.test.service.CardVerificationService;
import com.line.test.service.CardVerificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card-scheme")
public class CardApi {

    private final CardVerificationService cardVerificationService;

    @Autowired
    public CardApi(CardVerificationServiceImpl cardVerificationService) {
        this.cardVerificationService = cardVerificationService;
    }


    @GetMapping("/verify/{cardNumber}")
    public ResponseEntity<CardVerificationResponse> getCardVerification(@PathVariable String cardNumber){
        CardVerificationResponse verify = cardVerificationService.verify(cardNumber);
        if(verify != null){
            return new ResponseEntity<>(verify, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/stats")
    public ResponseEntity<CardUsageStatistics> getUsageStat(@RequestParam int start, @RequestParam int limit){
        CardUsageStatistics usageStatistics = cardVerificationService.getUsageStatistics(start, limit);
        return new ResponseEntity<>(usageStatistics,HttpStatus.OK);
    }
}
