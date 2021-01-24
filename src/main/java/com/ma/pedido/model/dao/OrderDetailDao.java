package com.ma.pedido.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.ma.pedido.model.entity.OrderDetail;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Long>{

}
