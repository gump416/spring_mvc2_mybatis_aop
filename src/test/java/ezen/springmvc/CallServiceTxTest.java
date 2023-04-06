package ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ezen.springmvc.transaction.service.CallService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CallServiceTxTest {
	@Autowired
	private CallService callService;

	@Test
	void printProxy() {
		log.info("callService class={}", callService.getClass());
	}

	@Test
	void internalCallTest() {
		// 트랜잭션 적용됨.
		callService.internal();
	}

	@Test
	void externalCallTest() {
		// 트랜잭션 적용 안됨.
		callService.external();
	}
}
