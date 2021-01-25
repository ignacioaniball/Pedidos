package com.ma.pedido.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "producto",
        "nombre",
        "cantidad",
        "importe"
})
public class OrderDetailResponse {

    @JsonProperty("producto")
    private String producto;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("cantidad")
    private Integer cantidad;
    @JsonProperty("importe")
    private Double importe;

    @JsonProperty("producto")
    public String getProducto() {
        return producto;
    }

    @JsonProperty("producto")
    public void setProducto(String producto) {
        this.producto = producto;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("cantidad")
    public Integer getCantidad() {
        return cantidad;
    }

    @JsonProperty("cantidad")
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @JsonProperty("importe")
    public Double getImporte() {
        return importe;
    }

    @JsonProperty("importe")
    public void setImporte(Double importe) {
        this.importe = importe;
    }

}
