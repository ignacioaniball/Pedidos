package com.ma.pedido.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "pedidos_cabecera")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "direccion",
        "email",
        "telefono",
        "horario",
        "detalle"
})
public class Order implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pedido_cabecera_id")
    private Long pedidoCabeceraId;

    @NotEmpty
    @NotNull
    @Column(name = "direccion")
    @JsonProperty("direccion")
    private String direccion;

    @NotEmpty
    @Column(name = "email")
    @Email
    @JsonProperty("email")
    private String email;

    @NotEmpty
    @Column(name = "telefono")
    @JsonProperty("telefono")
    private String telefono;

    @NotEmpty
    @Column(name = "horario")
    @JsonProperty("horario")
    private String horario;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaAlta;

    @NotEmpty
    @Column(name = "monto_total")
    @JsonProperty("monto_total")
    private int montoTotal;

    @NotEmpty
    @Column(name = "monto_desuento")
    @JsonProperty("descuento")
    private int montoDescuento;

    @NotEmpty
    @Column(name = "aplico_descuento")
    private Boolean aplicoDescuento;

    @NotEmpty
    private String estado;

    @OneToMany(mappedBy = "", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_detalle_id")
    @JsonProperty("detalle")
    private List<OrderDetail> detalle = null;

    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Order() {
        detalle = new ArrayList<>();
    }

    public List<OrderDetail> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<OrderDetail> detalle) {
        this.detalle = detalle;
    }

    public void addDetalle(OrderDetail detalle) {
        this.detalle.add(detalle);
    }

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

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
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

    public int getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(int montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}
