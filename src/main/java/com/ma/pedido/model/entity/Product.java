package com.ma.pedido.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "producto")
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @NotEmpty
    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String nombre;

    @NotEmpty
    @Column(name = "description_corta")
    @JsonProperty("descripcionCorta")
    private String descripcionCorta;

    @NotEmpty
    @Column(name = "description_larga")
    @JsonProperty("descripcionLarga")
    private String descripcionLarga;

    @NotNull
    @Column(name = "precio_unitario")
    @JsonProperty("precioUnitario")
    private Double precioUnitario;

    public String getIdProducto() {
        return id;
    }

    public void setIdProducto(String idProducto) {
        this.id = idProducto;
    }

    public String getNombreString() {
        return nombre;
    }

    public void setNombreString(String nombreString) {
        this.nombre = nombreString;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescriptcionLargaString() {
        return descripcionLarga;
    }

    public void setDescriptcionLargaString(String descriptcionLargaString) {
        this.descripcionLarga = descriptcionLargaString;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
