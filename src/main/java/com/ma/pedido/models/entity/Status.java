package com.ma.pedido.models.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
@Data
public class Status {

    @Id
    private Long id;

    @Column(name = "description")
    private String description;
}
