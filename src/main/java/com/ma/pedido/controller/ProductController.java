package com.ma.pedido.controller;

import com.ma.pedido.model.entity.Product;
import com.ma.pedido.model.response.ProductResponse;
import com.ma.pedido.service.jpa.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(PizzeriaController.class);
    @Autowired
    public ProductService productService;

    @PostMapping(value = "/productos", produces = "application/json")
    public ResponseEntity createProduct(@RequestBody Product producto) {
        logger.debug("Request Body ".concat(producto.toString()));
        productService.save(producto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/productos/{product_id}", produces = "application/json")
    public ResponseEntity modifyProduct(@PathVariable(value = "product_id") String product_id, @RequestBody Product product) {
        logger.debug("Request Body ".concat(product_id.toString()));
        Product productModified = productService.findOne(product_id);
        productModified.setNombreString(product.getNombreString());
        productModified.setPrecioUnitario(product.getPrecioUnitario());
        productModified.setDescripcionCorta(product.getDescripcionCorta());
        productModified.setDescriptcionLargaString(product.getDescriptcionLargaString());
        productService.save(productModified);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/productos/{product_id}", produces = "application/json")
    public ResponseEntity getProduct(@PathVariable(value = "product_id") String product_id) {
        try{
        Product product = productService.findOne(product_id);
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getIdProducto());
            productResponse.setNombre(product.getNombreString());
            productResponse.setDescripcionCorta(product.getDescripcionCorta());
            productResponse.setDescripcionLarga(product.getDescriptcionLargaString());
            productResponse.setPrecioUnitario(product.getPrecioUnitario());
        return new ResponseEntity(productResponse, HttpStatus.OK);
        }catch (NullPointerException e){
            return new ResponseEntity("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/productos/{product_id}", produces = "application/json")
    public ResponseEntity deleteProduct(@PathVariable(value = "product_id") String product_id) {
        productService.delete(product_id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
