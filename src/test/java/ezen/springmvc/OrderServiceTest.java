package ezen.springmvc;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ezen.springmvc.transaction.dto.Order;
import ezen.springmvc.transaction.mapper.OrderMapper;
import ezen.springmvc.transaction.service.NotEnoughMoneyException;
import ezen.springmvc.transaction.service.OrderService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class OrderServiceTest {

	@Autowired
	private OrderService orderService;

	@Test
	@Disabled
	public void completeTest() throws NotEnoughMoneyException {
		Order order = new Order();
		order.setMemberId("tester1");
		orderService.order(order);
		log.info("주문 정상 처리 완료!");
	}
	
	@Test
	@Disabled
	public void runtimeExceptionTest() throws NotEnoughMoneyException {
		Order order = new Order();
		order.setMemberId("error");
		orderService.order(order);
		log.info("시스템 예외로 롤백처리됨.");
	}
	
	@Test
	public void bizExceptionTest() {
		Order order = new Order();
		order.setMemberId("poor");
		try {
		    orderService.order(order);
		} catch (NotEnoughMoneyException e) {
		    log.info("별도의 계좌로 입금 안내합니다.");
		}
	}
}

