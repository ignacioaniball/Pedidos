package com.ma.pedido.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "direccion",
        "email",
        "telefono",
        "horario",
        "detalle"
})
public class OrderRequest {

    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("horario")
    private String horario;
    @JsonProperty("detalle")
    private List<OrderDetailRequest> detalle = null;

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
    public List<OrderDetailRequest> getDetalle() {
        return detalle;
    }

    @JsonProperty("detalle")
    public void setDetalle(List<OrderDetailRequest> detalle) {
        this.detalle = detalle;
    }
}

