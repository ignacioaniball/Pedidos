package com.ma.pedido.model.dto;

import com.ma.pedido.model.entity.OrderDetail;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private String direccion;
    private String email;
    private String telefono;
    private String horario;
    private Date fechaAlta;
    private int montoTotal;
    private int montoDescuento;
    private Boolean aplicoDescuento;
    private String estado;
    private List<OrderDetail> detalles;

    public OrderDTO() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(int montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public Boolean getAplicoDescuento() {
        return aplicoDescuento;
    }

    public void setAplicoDescuento(Boolean aplicoDescuento) {
        this.aplicoDescuento = aplicoDescuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<OrderDetail> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<OrderDetail> detalles) {
        this.detalles = detalles;
    }
}
