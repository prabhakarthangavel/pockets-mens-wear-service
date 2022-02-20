package com.pockets.menswear.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private long id;

    private String name;

    private String category;

    private int actualPrice;

    private int discountedPrice;

    private String description;

    private SizeRequest sizes;

    private String imageUrl;
}
