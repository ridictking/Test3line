package com.line.test.repo;

import com.line.test.model.Card;
import com.line.test.model.CardLog;
import com.line.test.model.CardUsageStatistics;
import com.line.test.model.Payload;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class DummyCardRepo {

    private final List<Card> cards;
    private final List<CardLog> logs;

    public DummyCardRepo() {
        this.logs = Arrays.asList(
                new CardLog("visa","debit","UBS","1234567891011547", LocalDateTime.now()),
                new CardLog("visa","debit","UBS","1234567891011547",LocalDateTime.now().plusDays(1)),
                new CardLog("visa","debit","UBS","1234567891011544",LocalDateTime.now()),
                new CardLog("visa","debit","UBS","1234567891011544",LocalDateTime.now().plusDays(1)),
                new CardLog("visa","debit","UBS","1234567891011544",LocalDateTime.now()),
                new CardLog("visa","debit","UBS","1234567891011547",LocalDateTime.now().plusDays(2)),
                new CardLog("visa","debit","UBS","1234567891011547",LocalDateTime.now()),
                new CardLog("visa","debit","UBS","1234567891011542",LocalDateTime.now().plusDays(2)),
                new CardLog("visa","debit","UBS","1234567891011542",LocalDateTime.now()),
                new CardLog("mastercard","debit","AFRI","1234567891011548", LocalDateTime.now()),
                new CardLog("mastercard","debit","AFRI","1234567891011548",LocalDateTime.now().plusDays(1)),
                new CardLog("mastercard","debit","AFRI","1234567891011548",LocalDateTime.now()),
                new CardLog("mastercard","debit","AFRI","1234567891011543",LocalDateTime.now().plusDays(1)),
                new CardLog("mastercard","debit","AFRI","1234567891011543",LocalDateTime.now()),
                new CardLog("mastercard","debit","AFRI","1234567891011543",LocalDateTime.now().plusDays(2)),
                new CardLog("mastercard","debit","AFRI","1234567891011548",LocalDateTime.now())
                );
        this.cards =  Arrays.asList(new Card("visa","debit","UBS","1234567891011547"),
                new Card("mastercard","debit","AFRI","1234567891011548"),
                new Card("amex","debit","MOBI","1234567891011549"));;
    }


    public List<Card> getCards(){
        return cards;
    }

    public Optional<Card> getCard(String cardNumber){
        return cards.stream().filter(x -> x.getCardNumber().equals(cardNumber)).findFirst();
    }

    public CardUsageStatistics getStat(int start, int limit){
        CardUsageStatistics stat = new CardUsageStatistics();
        Map<String, Long> summaryStat = logs.stream().collect(Collectors.groupingBy(CardLog::getCardNumber, Collectors.counting()));
        Map<String, Long> map = summaryStat.entrySet().stream().skip(start - 1).limit(limit).flatMap(Stream::of)
                .collect(Collectors.toMap(m -> (m.getKey().substring(0,3)+m.getKey().substring(m.getKey().length()-3)), Map.Entry::getValue));
        Payload payload = new Payload();
        payload.setRecord((HashMap<String, Long>) map);
        stat.setPayload((HashMap<String, Long>) map);
        stat.setLimit(limit);
        stat.setSize(summaryStat.size());
        stat.setStart(start);
        stat.setSuccess(true);
        return stat;
    }
}
