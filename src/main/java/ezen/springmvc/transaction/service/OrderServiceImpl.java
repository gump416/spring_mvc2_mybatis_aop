package ezen.springmvc.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ezen.springmvc.transaction.dto.Order;
import ezen.springmvc.transaction.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	/*
	 * @Transactional 
	 * public void order(Order order){ 
	 * 	 orderMapper.create(order); 
	 * }
	 */

	@Transactional
	//@Transactional(rollbackFor = NotEnoughMoneyException.class)
	public void order(Order order) throws NotEnoughMoneyException {
		log.info("===== order() 메소드 호출됨 =====");
		// #1. 주문테이블에 주문 관련 기본 정보 저장
		orderMapper.create(order);

		// #2. 결재 처리 테스트
		log.info(">> 결제 프로세스 진입");
		// 회원 아이디가 error인 경우 테스트를 위해 RuntimeException 발생 (롤백)
		if (order.getMemberId().equals("error")) {
			log.info("※ 결재 관련 시스템(런타임) 예외 발생 가정 ※");
			throw new RuntimeException("시스템(런타임) 예외발생하였습니다.");
		} else if (order.getMemberId().equals("poor")) {
			// 회원 아이디가 poor인 경우 테스트를 위해 Exception 발생
			log.info("※ 잔고 부족 비즈니스 예외 발생 가정 ※");
			// 주문테이블의 payStatus를 대기로 변경
			order.setPayStatus("대기");
			orderMapper.updatePayStatus(order);
			throw new NotEnoughMoneyException("고객님 잔고가 부족합니다");
		} else {
			// 정상 결재 처리
			log.info(">> 정상 결재 승인 가정");
			order.setPayStatus("완료");
			orderMapper.updatePayStatus(order);
		}
		log.info(">> 결제 프로세스 완료");
		log.info("===== order() 메소드 종료 =====");
	}
}



