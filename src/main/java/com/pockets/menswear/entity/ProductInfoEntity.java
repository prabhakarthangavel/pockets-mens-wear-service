package com.pockets.menswear.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product_info")
public class ProductInfoEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "actual_price")
    private int actualPrice;

    @Column(name = "discounted_price")
    private int discountedPrice;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "productInfoEntity", fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private SizeEntity sizeEntity;
}
