package com.ma.pedido.services;

import com.ma.pedido.models.request.OrderRequest;
import com.ma.pedido.models.response.OrderResponse;

import java.util.List;

public interface PizzeriaService {

    public OrderResponse createOrder(OrderRequest pedido);

    public List getOrderList(String fecha);

    public List getActiveOrderList(String fecha);

}