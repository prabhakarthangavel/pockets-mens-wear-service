package com.pockets.menswear.service;

import com.pockets.menswear.request.ProductRequest;

import java.util.List;

public interface ProductsService {

    List<ProductRequest> getAllProducts();

    List<ProductRequest> getProducts(String category);

    ProductRequest getProductDetail(long id) throws Exception;

    List<ProductRequest> getTopDeals();
}
