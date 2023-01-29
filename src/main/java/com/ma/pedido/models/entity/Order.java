package com.ma.pedido.models.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "pedido_cabecera")
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pedido_cabecera_id")
    @ApiModelProperty(notes = "The database generated product ID.")
    private Long pedidoCabeceraId;
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "The create date.")
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
}