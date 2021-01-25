package com.ma.pedido.controller;

import com.ma.pedido.model.request.OrderRequest;
import com.ma.pedido.service.PizzeriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PizzeriaController {
    private static final Logger logger = LoggerFactory.getLogger(PizzeriaController.class);
    @Autowired
    private PizzeriaService pizzeriaService;

    @PostMapping(value = "/pedidos", produces = "application/json")
    public ResponseEntity createOrder(@RequestBody OrderRequest orderRequest) {
        logger.debug("Request Body ".concat(orderRequest.toString()));
        validateOrderRequest(orderRequest);
        return new ResponseEntity(pizzeriaService.createOrder(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/pedidos")
    public ResponseEntity getOrderList(@RequestParam String fecha) {
        return new ResponseEntity(pizzeriaService.getOrderList(fecha), HttpStatus.OK);
    }

    private void validateOrderRequest(OrderRequest orderRequest){
        StringUtils.isEmpty(orderRequest.getDireccion());
        StringUtils.isEmpty(orderRequest.getEmail());
        StringUtils.isEmpty(orderRequest.getTelefono());
        StringUtils.isEmpty(orderRequest.getHorario());
    }
}
