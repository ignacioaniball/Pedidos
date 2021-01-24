package com.ma.pedido.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "producto")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "producto_id")
    private String productoId;

    @NotEmpty
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotEmpty
    @Column(name = "description_corta")
    private String descripcionCorta;

    @NotEmpty
    @Column(name = "description_larga")
    private String descriptcionLarga;

    @NotNull
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    public String getIdProducto() {
        return productoId;
    }

    public void setIdProducto(String idProducto) {
        this.productoId = idProducto;
    }

    public String getNombreString() {
        return nombreProducto;
    }

    public void setNombreString(String nombreString) {
        this.nombreProducto = nombreString;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescriptcionLargaString() {
        return descriptcionLarga;
    }

    public void setDescriptcionLargaString(String descriptcionLargaString) {
        this.descriptcionLarga = descriptcionLargaString;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
