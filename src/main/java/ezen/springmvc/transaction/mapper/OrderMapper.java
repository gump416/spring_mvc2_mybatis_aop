package ezen.springmvc.transaction.mapper;

import org.apache.ibatis.annotations.Mapper;
import ezen.springmvc.transaction.dto.Order;

@Mapper
public interface OrderMapper {
	public void create(Order order);
	public void updatePayStatus(Order order);
}






