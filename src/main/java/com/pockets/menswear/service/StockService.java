package com.pockets.menswear.service;

import com.pockets.menswear.request.ProductRequest;

public interface StockService {

    void createStock(ProductRequest stock);

    void editStock(ProductRequest stock);
}
