package ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ezen.springmvc.transaction.service.CallService;
import ezen.springmvc.transaction.service.CallService2;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CallServiceTxTest2 {
	@Autowired
	private CallService2 callService2;

	@Test
	void printProxy() {
		log.info("callService class={}", callService2.getClass());
	}

	@Test
	void externalCallTest() {
		// 트랜잭션 적용됨.
		callService2.external();
	}
}
