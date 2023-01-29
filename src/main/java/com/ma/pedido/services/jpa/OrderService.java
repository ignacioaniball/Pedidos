package com.ma.pedido.services.jpa;

import com.ma.pedido.models.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {

    public List<Order> findAll();

    public List<Order> findByDate(Date date);

    public List<Order> findByDateStatus(Date date);

    public void save(Order order);

    public Order findOne(Long id);

    public void delete(Long id);

}
