package com.pockets.menswear.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "size")
public class SizeEntity implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private ProductInfoEntity productInfoEntity;

    @Column(name = "small")
    private int small;

    @Column(name = "medium")
    private int medium;

    @Column(name = "large")
    private int large;

    @Column(name = "xlarge")
    private int xlarge;

    @Column(name = "xxlarge")
    private int xxlarge;
}
