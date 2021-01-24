package com.ma.pedido.model.dao;

import com.ma.pedido.model.entity.Order;
import com.ma.pedido.model.response.OrderResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderDao extends CrudRepository<Order, Long> {

    @Query(value = "SELECT * FROM pedido_cabecera WHERE fecha_alta = :date ORDER BY horario DESC", nativeQuery = true)
    List<OrderResponse> findByDate(@Param("date") Date date);
}
