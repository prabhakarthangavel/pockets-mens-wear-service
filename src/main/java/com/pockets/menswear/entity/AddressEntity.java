package com.pockets.menswear.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "address")
public class AddressEntity implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrdersEntity ordersEntity;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;
}
