package com.pockets.menswear.service.Impl;

import com.pockets.menswear.entity.SizeEntity;
import com.pockets.menswear.repo.ProductInfoRepo;
import com.pockets.menswear.request.ProductRequest;
import com.pockets.menswear.request.SizeRequest;
import com.pockets.menswear.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpls implements ProductsService {

    @Autowired
    private ProductInfoRepo productsRepo;

    @Override
    public List<ProductRequest> getProducts(final String category) {
        List<ProductRequest> productsList = new ArrayList<>();
        this.productsRepo.findByCategory(category).forEach(item -> {
            ProductRequest product = new ProductRequest();
            product.setName(item.getName());
            product.setCategory(item.getCategory());
            product.setActualPrice(item.getActualPrice());
            product.setDiscountedPrice(item.getDiscountedPrice());
            product.setDescription(item.getDescription());
            product.setImageUrl(item.getImageUrl());
            SizeEntity size = item.getSizeEntity();
            SizeRequest sizeRequest = new SizeRequest(size.getSmall(), size.getMedium(), size.getLarge(), size.getXlarge(), size.getXxlarge());
            product.setSizes(sizeRequest);
            productsList.add(product);
        });
        return productsList;
    }
}
