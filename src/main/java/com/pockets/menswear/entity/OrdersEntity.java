package com.pockets.menswear.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrdersEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userid")
    private long userid;

    @Column(name = "productid")
    private long productid;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ordersEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QuantityEntity> quantity;

    @Column(name = "mobile")
    private String mobile;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ordersEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<AddressEntity> address;
}
