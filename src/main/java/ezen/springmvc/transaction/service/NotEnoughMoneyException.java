package ezen.springmvc.transaction.service;

/** 사용자 정의 컴파일 체크 예외(비즈니스 예외) */
public class NotEnoughMoneyException extends Exception{
	public NotEnoughMoneyException(String message) {
		super(message);
	}
}

