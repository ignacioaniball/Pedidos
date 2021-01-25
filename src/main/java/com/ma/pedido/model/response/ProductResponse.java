package com.ma.pedido.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nombre",
        "descripcionCorta",
        "descripcionLarga",
        "precioUnitario"
})
public class ProductResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("descripcionCorta")
    private String descripcionCorta;
    @JsonProperty("descripcionLarga")
    private String descripcionLarga;
    @JsonProperty("precioUnitario")
    private Double precioUnitario;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("descripcionCorta")
    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    @JsonProperty("descripcionCorta")
    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    @JsonProperty("descripcionLarga")
    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    @JsonProperty("descripcionLarga")
    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    @JsonProperty("precioUnitario")
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    @JsonProperty("precioUnitario")
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}

