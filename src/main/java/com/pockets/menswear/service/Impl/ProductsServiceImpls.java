package com.pockets.menswear.service.Impl;

import com.pockets.menswear.entity.ProductInfoEntity;
import com.pockets.menswear.entity.SizeEntity;
import com.pockets.menswear.repo.ProductInfoRepo;
import com.pockets.menswear.request.ProductRequest;
import com.pockets.menswear.request.SizeRequest;
import com.pockets.menswear.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductsServiceImpls implements ProductsService {

    @Autowired
    private ProductInfoRepo productsRepo;

    @Override
    public List<ProductRequest> getAllProducts() {
        List<ProductRequest> productsList = new ArrayList<>();
        this.productsRepo.findAll().forEach(item -> {
            ProductRequest product = new ProductRequest();
            product.setId(item.getId());
            product.setName(item.getName());
            product.setCategory(item.getCategory());
            product.setActualPrice(item.getActualPrice());
            product.setDiscountedPrice(item.getDiscountedPrice());
            product.setDescription(item.getDescription());
            product.setImageUrl(item.getImageUrl());
            SizeEntity size = item.getSizeEntity();
            SizeRequest sizeRequest = new SizeRequest(size.getId(), size.getSmall(), size.getMedium(), size.getLarge(), size.getXlarge(), size.getXxlarge());
            product.setSizes(sizeRequest);
            productsList.add(product);
        });
        return productsList;
    }

    @Override
    public List<ProductRequest> getProducts(final String category) {
        List<ProductRequest> productsList = new ArrayList<>();
        this.productsRepo.findByCategory(category).forEach(item -> {
            ProductRequest product = new ProductRequest();
            product.setId(item.getId());
            product.setName(item.getName());
            product.setCategory(item.getCategory());
            product.setActualPrice(item.getActualPrice());
            product.setDiscountedPrice(item.getDiscountedPrice());
            product.setDescription(item.getDescription());
            product.setImageUrl(item.getImageUrl());
            SizeEntity size = item.getSizeEntity();
            SizeRequest sizeRequest = new SizeRequest(size.getId(), size.getSmall(), size.getMedium(), size.getLarge(), size.getXlarge(), size.getXxlarge());
            product.setSizes(sizeRequest);
            productsList.add(product);
        });
        return productsList;
    }

    @Override
    public ProductRequest getProductDetail(long id) throws Exception {
        Optional<ProductInfoEntity> productInfo = this.productsRepo.findById(id);
        ProductRequest product = new ProductRequest();
        if (productInfo.isPresent()) {
            product.setId(productInfo.get().getId());
            product.setName(productInfo.get().getName());
            product.setCategory(productInfo.get().getCategory());
            product.setActualPrice(productInfo.get().getActualPrice());
            product.setDiscountedPrice(productInfo.get().getDiscountedPrice());
            product.setDescription(productInfo.get().getDescription());
            product.setImageUrl(productInfo.get().getImageUrl());
            SizeEntity size = productInfo.get().getSizeEntity();
            SizeRequest sizeRequest = new SizeRequest(size.getId(), size.getSmall(), size.getMedium(), size.getLarge(), size.getXlarge(), size.getXxlarge());
            product.setSizes(sizeRequest);
            return product;
        } else {
            throw new Exception("Invalid Id, product not found");
        }

    }

    @Override
    public List<ProductRequest> getTopDeals() {
        List<ProductRequest> productsList = new ArrayList<>();
        List<ProductInfoEntity> entityList = this.productsRepo.findByDiscountedPriceGreaterThan(0);
        if (!entityList.isEmpty()) {
            Collections.sort(entityList, new Comparator<ProductInfoEntity>() {
                @Override
                public int compare(ProductInfoEntity o1, ProductInfoEntity o2) {
                    int disount1 = 100 * (o1.getActualPrice() - o1.getDiscountedPrice()) / o1.getActualPrice();
                    int disount2 = 100 * (o2.getActualPrice() - o2.getDiscountedPrice()) / o2.getActualPrice();
                    return disount2 - disount1;
                }
            });
            entityList.forEach(item -> {
                ProductRequest product = new ProductRequest();
                product.setId(item.getId());
                product.setName(item.getName());
                product.setCategory(item.getCategory());
                product.setActualPrice(item.getActualPrice());
                product.setDiscountedPrice(item.getDiscountedPrice());
                product.setDescription(item.getDescription());
                product.setImageUrl(item.getImageUrl());
                SizeEntity size = item.getSizeEntity();
                SizeRequest sizeRequest = new SizeRequest(size.getId(), size.getSmall(), size.getMedium(), size.getLarge(), size.getXlarge(), size.getXxlarge());
                product.setSizes(sizeRequest);
                productsList.add(product);
            });
        }
        return productsList;
    }
}
