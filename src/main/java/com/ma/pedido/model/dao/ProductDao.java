package com.ma.pedido.model.dao;

import com.ma.pedido.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDao extends CrudRepository<Product, String> {

    @Query(value = "SELECT * FROM producto WHERE id = :product ", nativeQuery = true)
    Product findOne(@Param("product") String product);
}
