package com.ma.pedido.controller;

import com.ma.pedido.model.dto.ProductDto;
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

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    public ProductService productService;

    @PostMapping(value = "/productos", produces = "application/json")
    public ResponseEntity<HttpStatus> createProduct(@RequestBody ProductDto productDto) {
        logger.debug("Request Body ".concat(productDto.toString()));
        Product product = new Product();
        product.setIdProducto(productDto.getId());
        product.setNombreString(productDto.getNombre());
        product.setDescripcionCorta(productDto.getDescripcionCorta());
        product.setDescripcionLargaString(productDto.getDescripcionLarga());
        product.setPrecioUnitario(productDto.getPrecioUnitario());
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/productos/{product_id}", produces = "application/json")
    public ResponseEntity<HttpStatus> modifyProduct(@PathVariable(value = "product_id") String productId, @RequestBody ProductDto productDto) {
        logger.debug("Request Body ".concat(productId));
        Product productModified = productService.findOne(productId);
        productModified.setNombreString(productDto.getNombre());
        productModified.setPrecioUnitario(productDto.getPrecioUnitario());
        productModified.setDescripcionCorta(productDto.getDescripcionCorta());
        productModified.setDescripcionLargaString(productDto.getDescripcionLarga());
        productService.save(productModified);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/productos/{product_id}", produces = "application/json")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable(value = "product_id") String productId) {
        try{
        Product product = productService.findOne(productId);
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getIdProducto());
            productResponse.setNombre(product.getNombreString());
            productResponse.setDescripcionCorta(product.getDescripcionCorta());
            productResponse.setDescripcionLarga(product.getDescripcionLargaString());
            productResponse.setPrecioUnitario(product.getPrecioUnitario());
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }catch (NullPointerException e){
            return new ResponseEntity("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/productos/{product_id}", produces = "application/json")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable(value = "product_id") String productId) {
        productService.delete(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
