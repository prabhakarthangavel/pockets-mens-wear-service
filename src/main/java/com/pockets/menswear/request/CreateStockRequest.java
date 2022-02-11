package com.pockets.menswear.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateStockRequest {

    private String name;

    private String category;

    private int actualPrice;

    private int discountedPrice;

    private String description;

    private SizeRequest sizes;

    private String imageUrl;
}
