package com.ma.pedido.services.jpa;

import com.ma.pedido.models.entity.Product;
import org.springframework.data.repository.query.Param;

public interface ProductService {

    public void save(Product producto);

    public void delete(String id);

    public Product findOne(@Param("product") String product);

}
