package com.ma.pedido.service;

import com.ma.pedido.model.entity.Order;
import com.ma.pedido.model.response.OrderResponse;

import java.util.List;

public interface PizzeriaService {

    public OrderResponse createPedido(Order pedido);

    public List listarPedidoCabecera(String fecha);

}