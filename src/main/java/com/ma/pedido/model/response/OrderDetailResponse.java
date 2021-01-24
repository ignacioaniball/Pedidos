package com.ma.pedido.model.response;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
