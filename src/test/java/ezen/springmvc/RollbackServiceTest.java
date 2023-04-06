package ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ezen.springmvc.transaction.service.CallService;
import ezen.springmvc.transaction.service.RollbackService;
import ezen.springmvc.transaction.service.RollbackService.MyException;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class RollbackServiceTest {

	@Autowired
	private RollbackService rollbackService;

	@Test
	void runtimeExceptionTest() {
		// 롤백
		rollbackService.runtimeException();
	}

	@Test
	void checkedExceptionTest() throws MyException {
		// 커밋
		rollbackService.checkedException();
	}

	@Test
	void rollbackForTest() throws MyException {
		// 롤백
		rollbackService.rollbackFor();
	}

}
