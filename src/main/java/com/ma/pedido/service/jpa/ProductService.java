package com.ma.pedido.service.jpa;

import com.ma.pedido.model.entity.Product;
import org.springframework.data.repository.query.Param;

public interface ProductService {

    public void save(Product producto);

    public void delete(String id);

    public Product findOne(@Param("product") String product);

}
