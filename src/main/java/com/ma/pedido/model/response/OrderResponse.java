package com.ma.pedido.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ma.pedido.model.entity.Order;
import com.ma.pedido.model.entity.OrderDetail;

import java.util.Date;
import java.util.List;

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
    private Date fecha;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("horario")
    private String horario;
    @JsonProperty("detalle")
    private List<OrderDetail> detalle = null;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("descuento")
    private Boolean descuento;
    @JsonProperty("estado")
    private String estado;

    public OrderResponse(Order order) {
    }

    @JsonProperty("fecha")
    public Date getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(Date fecha) {
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
    public List<OrderDetail> getDetalle() {
        return detalle;
    }

    @JsonProperty("detalle")
    public void setDetalle(List<OrderDetail> detalle) {
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
