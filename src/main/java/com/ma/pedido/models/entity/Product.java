package com.ma.pedido.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "producto")
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

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

    public Product() {
    }

    public Product(String nombre, String descripcionCorta, String descripcionLarga, Double precioUnitario) {
        this.nombre = nombre;
        this.descripcionCorta = descripcionCorta;
        this.descripcionLarga = descripcionLarga;
        this.precioUnitario = precioUnitario;
    }
}
