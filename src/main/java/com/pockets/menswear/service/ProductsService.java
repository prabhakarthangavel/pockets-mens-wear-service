package com.pockets.menswear.service;

import com.pockets.menswear.request.ProductRequest;

import java.util.List;

public interface ProductsService {

    List<ProductRequest> getProducts(String category);
}
