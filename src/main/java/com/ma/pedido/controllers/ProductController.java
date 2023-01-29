package com.ma.pedido.controllers;

import com.ma.pedido.models.dto.ProductDto;
import com.ma.pedido.models.entity.Product;
import com.ma.pedido.models.response.ProductResponse;
import com.ma.pedido.services.jpa.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    public ProductService productService;

    @PostMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a product.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<HttpStatus> createProduct(@RequestBody ProductDto productDto) {
        logger.debug("Request Body ".concat(productDto.toString()));
        Product product = new Product();
        product.setId(productDto.getId());
        product.setNombre(productDto.getNombre());
        product.setDescripcionCorta(productDto.getDescripcionCorta());
        product.setDescripcionLarga(productDto.getDescripcionLarga());
        product.setPrecioUnitario(productDto.getPrecioUnitario());
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/productos/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Modify a product.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "NO_CONTENT"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<HttpStatus> modifyProduct(@PathVariable(value = "product_id") String productId, @RequestBody ProductDto productDto) {
        logger.debug("Request Body ".concat(productId));
        Product productModified = productService.findOne(productId);
        productModified.setNombre(productDto.getNombre());
        productModified.setPrecioUnitario(productDto.getPrecioUnitario());
        productModified.setDescripcionCorta(productDto.getDescripcionCorta());
        productModified.setDescripcionLarga(productDto.getDescripcionLarga());
        productService.save(productModified);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/productos/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a product.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<ProductResponse> getProduct(@PathVariable(value = "product_id") String productId) {
        try{
        Product product = productService.findOne(productId);
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setNombre(product.getNombre());
            productResponse.setDescripcionCorta(product.getDescripcionCorta());
            productResponse.setDescripcionLarga(product.getDescripcionLarga());
            productResponse.setPrecioUnitario(product.getPrecioUnitario());
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }catch (NullPointerException e){
            return new ResponseEntity("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/productos/{product_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Remove a product.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable(value = "product_id") String productId) {
        productService.delete(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
