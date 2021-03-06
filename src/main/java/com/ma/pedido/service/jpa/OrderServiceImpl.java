package com.ma.pedido.service.jpa;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.pedido.model.dao.OrderDao;
import com.ma.pedido.model.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao pedidoCabeceraDao;

	@Override
	@Transactional( readOnly = true)
	public List<Order> findAll() {
		return (List<Order>) pedidoCabeceraDao.findAll();
	}

	@Override
	@Transactional
	public void save(Order pedidoCabecera) {
		pedidoCabeceraDao.save(pedidoCabecera);
	}

	@Override
	public List<Order> findByDate(Date date) {
		return pedidoCabeceraDao.findByDate(date);
	}

	@Override
	@Transactional(readOnly = true)
	public Order findOne(Long id) {
		return pedidoCabeceraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {pedidoCabeceraDao.deleteById(id);
	}

}
