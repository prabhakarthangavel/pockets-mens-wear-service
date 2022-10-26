package com.pockets.menswear.request;

import lombok.Data;

@Data
public class CartRequest {
    private long productid;
    private int quantity;
    private String size;
}
