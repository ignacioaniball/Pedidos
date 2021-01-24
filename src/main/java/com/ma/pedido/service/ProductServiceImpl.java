package com.ma.pedido.service;

import com.ma.pedido.model.dao.ProductDao;
import com.ma.pedido.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public void save(Product producto) {
        productDao.save(producto);
    }

    @Override
    public Product findOne(String product) {
        return productDao.findOne(product);
    }

    @Override
    public void delete(String id) {
        productDao.deleteById(id);
    }
}