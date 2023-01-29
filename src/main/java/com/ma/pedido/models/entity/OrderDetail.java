package com.ma.pedido.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "pedido_detalle")
@Data
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pedido_detalle_id")
    private Long pedidoDetalleId;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_cabecera_id")
    private Order order;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Product producto;
    @OneToOne(targetEntity = Status.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private Status statu;
    @NotEmpty
    private Long productId;
    @NotEmpty
    @Column(name = "cantidad")
    private Integer cantidad;
    @NotEmpty
    @Column(name = "importe")
    private Double importe;
}
