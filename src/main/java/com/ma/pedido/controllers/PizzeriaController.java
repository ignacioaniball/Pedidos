package com.ma.pedido.controllers;

import com.ma.pedido.models.request.OrderRequest;
import com.ma.pedido.models.response.OrderResponse;
import com.ma.pedido.services.PizzeriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class PizzeriaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PizzeriaController.class);
    @Autowired
    private PizzeriaService pizzeriaService;

    /**
     *
     * @param orderRequest
     * @return
     */
    @PostMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create an pizzeria order.",
            notes = "This order has different order details.",
            response = OrderResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        validateOrderRequest(orderRequest);
        return new ResponseEntity(pizzeriaService.createOrder(orderRequest), HttpStatus.CREATED);
    }

    /**
     *
     * @param fecha
     * @return
     */
    @GetMapping(value = "/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a list of order in base of the date.", response = OrderResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<OrderResponse> getOrderList(@RequestParam String fecha) {
        return new ResponseEntity(pizzeriaService.getOrderList(fecha), HttpStatus.OK);
    }

    @GetMapping(value = "/pedidos/activos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> getActiveOrderList(@RequestParam String fecha) {
        return new ResponseEntity(pizzeriaService, HttpStatus.OK);
    }

    /**
     *
     * @param orderRequest
     */
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
