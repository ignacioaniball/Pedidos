package com.ma.pedido.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "pedido_cabecera")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pedido_cabecera_id")
    private Long pedidoCabeceraId;
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    @NotEmpty
    @NotNull
    @Column(name = "direccion")
    private String direccion;
    @NotEmpty
    @Column(name = "email")
    @Email
    private String email;
    @NotEmpty
    @Column(name = "telefono")
    private String telefono;
    @NotEmpty
    @Column(name = "horario")
    private String horario;
    @NotEmpty
    @Column(name = "total")
    private Double total;
    @NotEmpty
    @Column(name = "descuento")
    private Boolean descuento;
    @NotEmpty
    @Column(name = "estado")
    private String estado;

    public Long getPedidoCabeceraId() {
        return pedidoCabeceraId;
    }

    public void setPedidoCabeceraId(Long pedidoCabeceraId) {
        this.pedidoCabeceraId = pedidoCabeceraId;
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

    public @NotEmpty String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotEmpty String telefono) {
        this.telefono = telefono;
    }

    public @NotEmpty String getHorario() {
        return horario;
    }

    public void setHorario(@NotEmpty String horario) {
        this.horario = horario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getDescuento() {
        return descuento;
    }

    public void setDescuento(Boolean descuento) {
        this.descuento = descuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
