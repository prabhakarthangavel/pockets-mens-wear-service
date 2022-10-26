package com.pockets.menswear.service;

import com.pockets.menswear.entity.CartEntity;
import com.pockets.menswear.entity.ProductInfoEntity;
import com.pockets.menswear.request.CartRequest;
import com.pockets.menswear.request.ProductRequest;
import com.pockets.menswear.response.CartContentResponse;

import java.util.List;
import java.util.Map;

public interface ProductsService {

    List<ProductRequest> getAllProducts();

    List<ProductRequest> getProducts(String category);

    ProductRequest getProductDetail(long id) throws Exception;

    List<ProductRequest> getTopDeals();

    void addToCart(CartRequest cartRequest);

    List<CartEntity> fetchCartItems();

    List<CartContentResponse> fetchCartItemsDetail();
}
