package com.ma.pedido.controller;

import com.ma.pedido.model.entity.Order;
import com.ma.pedido.service.PizzeriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PizzeriaController {
    private static final Logger logger = LoggerFactory.getLogger(PizzeriaController.class);
    @Autowired
    private PizzeriaService pizzeriaService;

    @PostMapping(value = "/pedidos", produces = "application/json")
    public ResponseEntity createOrder(@RequestBody Order pedido) {
        logger.debug("Request Body ".concat(pedido.toString()));
        return new ResponseEntity(pizzeriaService.createPedido(pedido), HttpStatus.CREATED);
    }

    @GetMapping(value = "/pedidos")
    public List getOrderList(@RequestParam String fecha) {
        return pizzeriaService.listarPedidoCabecera(fecha);
    }
}
