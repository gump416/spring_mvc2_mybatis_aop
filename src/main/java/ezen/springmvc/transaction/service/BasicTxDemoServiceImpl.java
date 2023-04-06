package ezen.springmvc.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

/**
 * 스프링 트랜잭션 적용 여부 확인을 위한 테스트 서비스
 */
@Service
@Slf4j
public class BasicTxDemoServiceImpl  implements BasicTxDemoService {
	// 트랜잭션 AOP 적용 메소드
	@Transactional
	public void txMethod() {
		log.info("txMethod() 메소드 실행...");
		// 현재 쓰레드에 트랜잭션이 적용되어 있는지 확인
		// 트랜잭션 동기화 매니저를 통해 결과가 true면 트랜잭션이 적용됨을 의미한다.
		boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션  active = {}", txActive);
	}

	public void nonTxMethod() {
		log.info("nonTxMethod() 메소드 실행…");
		boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션  active = {}", txActive);
	}

}
