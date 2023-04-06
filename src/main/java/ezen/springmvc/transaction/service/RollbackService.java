package ezen.springmvc.transaction.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RollbackService {
	
	// 런타임 예외 발생 -> 롤백
	@Transactional
	public void runtimeException() {
		log.info("Called runtimeException()");
		throw new RuntimeException();
	}

	// 컴파일 체크 예외 발생 -> 커밋
	@Transactional
	public void checkedException() throws MyException {
		log.info("Called checkedException()");
		throw new MyException();
	}

	// 컴파일 체크 예외 발생 -> rollbackFor 설정 : 롤백
	@Transactional(rollbackFor = MyException.class)
	public void rollbackFor() throws MyException {
		log.info("Called rollbackFor()");
		throw new MyException();
	}
	
	// 테스트를 위한 사용자 예외 클래스
	static public class MyException extends Exception {
		
	}
}
