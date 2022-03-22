package com.pockets.menswear.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "order_quantity")
public class QuantityEntity implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrdersEntity ordersEntity;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "size")
    private String size;
}
