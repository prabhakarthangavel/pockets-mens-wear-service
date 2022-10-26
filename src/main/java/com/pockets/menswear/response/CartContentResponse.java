package com.pockets.menswear.response;

import com.pockets.menswear.entity.CartEntity;
import com.pockets.menswear.entity.ProductInfoEntity;
import lombok.Data;

@Data
public class CartContentResponse {
    private long productId;
    private String name;
    private String category;
    private int quantity;
    private String size;
    private int actualPrice;
    private int discountedPrice;
    private String imageUrl;
}
