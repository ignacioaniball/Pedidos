package com.ma.pedido.model.response;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fecha",
        "direccion",
        "email",
        "telefono",
        "horario",
        "detalle",
        "total",
        "descuento",
        "estado"
})
public class OrderResponse {

    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("horario")
    private String horario;
    @JsonProperty("detalle")
    private List<OrderDetailResponse> detalle = null;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("descuento")
    private Boolean descuento;
    @JsonProperty("estado")
    private String estado;

    @JsonProperty("fecha")
    public String getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @JsonProperty("direccion")
    public String getDireccion() {
        return direccion;
    }

    @JsonProperty("direccion")
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("telefono")
    public String getTelefono() {
        return telefono;
    }

    @JsonProperty("telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @JsonProperty("horario")
    public String getHorario() {
        return horario;
    }

    @JsonProperty("horario")
    public void setHorario(String horario) {
        this.horario = horario;
    }

    @JsonProperty("detalle")
    public List<OrderDetailResponse> getDetalle() {
        return detalle;
    }

    @JsonProperty("detalle")
    public void setDetalle(List<OrderDetailResponse> detalle) {
        this.detalle = detalle;
    }

    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Double total) {
        this.total = total;
    }

    @JsonProperty("descuento")
    public Boolean getDescuento() {
        return descuento;
    }

    @JsonProperty("descuento")
    public void setDescuento(Boolean descuento) {
        this.descuento = descuento;
    }

    @JsonProperty("estado")
    public String getEstado() {
        return estado;
    }

    @JsonProperty("estado")
    public void setEstado(String estado) {
        this.estado = estado;
    }
}