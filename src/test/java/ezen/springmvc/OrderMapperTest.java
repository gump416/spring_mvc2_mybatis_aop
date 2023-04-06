package ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ezen.springmvc.transaction.dto.Order;
import ezen.springmvc.transaction.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class OrderMapperTest {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Test
	void createTest() {
		Order order = new Order();
		order.setMemberId("hong");
		orderMapper.create(order);
		log.info("주문 등록 완료 : {}", order.getOrderId());
	}
}










