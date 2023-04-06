package ezen.springmvc.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CallService2 {
	
	@Autowired
	private InternalService internalService;

	public void external() {
		log.info("Called external");
		printTxInfo();
		// 트랜잭션 적용을 위해 외부 서비스객체의 비즈니스 메소드 호출
		internalService.internal();
	}

	private void printTxInfo() {
		boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션 active={}", txActive);
	}
}