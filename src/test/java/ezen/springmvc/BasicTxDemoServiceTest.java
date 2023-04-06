package ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ezen.springmvc.transaction.service.BasicTxDemoService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BasicTxDemoServiceTest {
	
	// 실제 서비스 객체 대신에 트랜잭션을 처리해주는 트랜잭션 프록시 객체가 스프링 빈에 등록되고,
	// 주입 받을 때도 실제 서비스 객체 대신에 트랜잭션 프록시 객체가 주입된다.
	@Autowired
	BasicTxDemoService basicTxDemoService;

	// AOP 트랜잭션 프록시 객체 확인
	@Test
	public void checkProxy() {
		Object proxy = basicTxDemoService.getClass();
		log.info("획득한 프록시객체 : {}", proxy);
	}

	@Test
	public void transactionTest() {
		basicTxDemoService.txMethod();
		basicTxDemoService.nonTxMethod();
	}

}



