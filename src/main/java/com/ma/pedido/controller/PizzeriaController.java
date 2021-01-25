package com.ma.pedido.controller;

import com.ma.pedido.model.request.OrderRequest;
import com.ma.pedido.model.response.OrderResponse;
import com.ma.pedido.service.PizzeriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class PizzeriaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PizzeriaController.class);
    @Autowired
    private PizzeriaService pizzeriaService;

    @PostMapping(value = "/pedidos", produces = "application/json")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        validateOrderRequest(orderRequest);
        return new ResponseEntity(pizzeriaService.createOrder(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/pedidos")
    public ResponseEntity<OrderResponse> getOrderList(@RequestParam String fecha) {
        return new ResponseEntity(pizzeriaService.getOrderList(fecha), HttpStatus.OK);
    }

    private void validateOrderRequest(OrderRequest orderRequest){
        if (StringUtils.isEmpty(orderRequest.getDireccion())){
            LOGGER.error("La variable dirreción no puede ser nula.a");
            throw new NullPointerException("La variable dirreción no puede ser nula.");
        }
        if (StringUtils.isEmpty(orderRequest.getEmail())){
            LOGGER.error("La variable email no puede ser nula.a");
            throw new NullPointerException("La variable email no puede ser nula.");
        }
        if (StringUtils.isEmpty(orderRequest.getTelefono())){
            LOGGER.error("La variable telefono no puede ser nula.a");
            throw new NullPointerException("La variable telefono no puede ser nula.");
        }
        if (StringUtils.isEmpty(orderRequest.getHorario())){
            LOGGER.error("La variable horario no puede ser nula.a");
            throw new NullPointerException("La variable horario no puede ser nula.");
        }
    }
}
