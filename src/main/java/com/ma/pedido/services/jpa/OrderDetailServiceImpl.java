package com.ma.pedido.services.jpa;

import com.ma.pedido.models.dao.OrderDetailDao;
import com.ma.pedido.models.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    public OrderDetailDao orderDetailDao;
    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailDao.save(orderDetail);
    }
}
