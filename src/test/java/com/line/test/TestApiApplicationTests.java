package com.line.test;

import com.line.test.model.CardUsageStatistics;
import com.line.test.model.CardVerificationResponse;
import com.line.test.service.CardVerificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestApiApplicationTests {

	@Autowired
	private CardVerificationService cardVerificationService;

	@Test
	public void contextLoads() {
		assertThat(cardVerificationService).isNotNull();
	}

	@Test
	public void testCardVerify(){
		String cardNumber = "1234567891011547";
		CardVerificationResponse verificationResponse = cardVerificationService.verify(cardNumber);
		assertThat(verificationResponse.getSuccess()).isTrue();
		assertThat(verificationResponse.getPayload().getScheme()).isEqualTo("visa");
		String cardNumber2 = "2234567891011547";
		CardVerificationResponse verificationResponse2 = cardVerificationService.verify(cardNumber2);
		assertThat(verificationResponse2.getSuccess()).isFalse();
		assertThat(verificationResponse2.getPayload()).isNull();
	}

	@Test
	public void testCardStat(){
		int limit = 3;
		int start = 1;
		CardUsageStatistics usageStatistics = cardVerificationService.getUsageStatistics(start, limit);
		assertThat(usageStatistics.getLimit()).isEqualTo(limit);
		assertThat(usageStatistics.getStart()).isEqualTo(start);
		assertThat(usageStatistics.getPayload().size()).isEqualTo(limit);
	}
}
