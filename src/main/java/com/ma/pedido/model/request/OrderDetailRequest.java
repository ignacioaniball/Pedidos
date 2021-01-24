package com.ma.pedido.model.request;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "producto",
        "cantidad"
})
public class OrderDetailRequest {

    @JsonProperty("producto")
    private String producto;
    @JsonProperty("cantidad")
    private Integer cantidad;

    @JsonProperty("producto")
    public String getProducto() {
        return producto;
    }

    @JsonProperty("producto")
    public void setProducto(String producto) {
        this.producto = producto;
    }

    @JsonProperty("cantidad")
    public Integer getCantidad() {
        return cantidad;
    }

    @JsonProperty("cantidad")
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
