package com.ma.pedido.service.jpa;

import com.ma.pedido.model.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    public List<Order> findAll();

    public List<Order> findByDate(Date date);

    public void save(Order order);

    public Order findOne(Long id);

    public void delete(Long id);

}
