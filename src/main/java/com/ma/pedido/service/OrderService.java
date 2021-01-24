package com.ma.pedido.service;

import java.util.Date;
import java.util.List;


import com.ma.pedido.model.entity.Order;
import com.ma.pedido.model.response.OrderResponse;

public interface OrderService {
	
	public List<Order> findAll();

	public List<OrderResponse> findByDate(Date date);
	
	public void save(Order pedidoCabecera);

	public Order findOne(Long id);
	
	public Order fetchByIdWithProducto(Long id);
	
	public void delete(Long id);
	
}
