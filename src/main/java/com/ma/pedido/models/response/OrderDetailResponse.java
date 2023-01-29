package com.ma.pedido.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "producto",
        "nombre",
        "cantidad",
        "importe"
})
@Data
public class OrderDetailResponse {

    @JsonProperty("producto")
    private Long producto;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("cantidad")
    private Integer cantidad;
    @JsonProperty("importe")
    private Double importe;
}
