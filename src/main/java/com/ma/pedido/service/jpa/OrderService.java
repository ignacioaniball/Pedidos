package com.ma.pedido.service.jpa;

import java.util.Date;
import java.util.List;


import com.ma.pedido.model.entity.Order;
import com.ma.pedido.model.response.OrderResponse;

public interface OrderService {
	
	public List<Order> findAll();

	public List<Order> findByDate(Date date);
	
	public void save(Order order);

	public Order findOne(Long id);

	public void delete(Long id);
	
}
