package com.ma.pedido.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ma.pedido.models.entity.OrderDetail;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Long>{

}
