package com.pockets.menswear.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = -7635414743203716687L;
    @Id
    @Column(name="role_id")
    @GeneratedValue
    private long role_id;

    @Column(name="role")
    private String role;

}
