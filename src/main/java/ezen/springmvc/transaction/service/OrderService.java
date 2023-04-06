package ezen.springmvc.transaction.service;

import ezen.springmvc.transaction.dto.Order;

public interface OrderService{
	public void order(Order order) throws NotEnoughMoneyException;
}

