package com.ma.pedido.service;

import com.ma.pedido.model.request.OrderRequest;
import com.ma.pedido.model.response.OrderResponse;

import java.util.List;

public interface PizzeriaService {

    public OrderResponse createOrder(OrderRequest pedido);

    public List getOrderList(String fecha);

}