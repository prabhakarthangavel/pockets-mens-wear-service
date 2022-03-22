package com.pockets.menswear.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cart")
public class CartEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userid")
    private long userid;

    @Column(name = "productid")
    private long productid;

    @Column(name = "quantity")
    private int quantity;

    @Column(name="size")
    private String size;
}
