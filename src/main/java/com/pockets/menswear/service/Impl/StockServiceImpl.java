package com.pockets.menswear.service.Impl;

import com.pockets.menswear.entity.ProductInfoEntity;
import com.pockets.menswear.entity.SizeEntity;
import com.pockets.menswear.repo.ProductInfoRepo;
import com.pockets.menswear.repo.SizeRepo;
import com.pockets.menswear.request.ProductRequest;
import com.pockets.menswear.request.SizeRequest;
import com.pockets.menswear.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private ProductInfoRepo productInfoRepo;

    @Autowired
    private SizeRepo sizeRepo;

    @Override
    public void createStock(ProductRequest stock) {
        ProductInfoEntity productInfo = new ProductInfoEntity();
        productInfo.setName(stock.getName());
        productInfo.setActualPrice(stock.getActualPrice());
        productInfo.setDiscountedPrice(stock.getDiscountedPrice());
        productInfo.setCategory(stock.getCategory());
        productInfo.setDescription(stock.getDescription());
        productInfo.setImageUrl(stock.getImageUrl());
        SizeEntity size = new SizeEntity();
        size.setSmall(stock.getSizes().getSmall());
        size.setMedium(stock.getSizes().getMedium());
        size.setLarge(stock.getSizes().getLarge());
        size.setXlarge(stock.getSizes().getXlarge());
        size.setXxlarge(stock.getSizes().getXxlarge());
        //set both entity
        productInfo.setSizeEntity(size);
        size.setProductInfoEntity(productInfo);
        this.productInfoRepo.save(productInfo);
    }

    @Override
    @Transactional
    public void editStock(ProductRequest stock) {
        this.productInfoRepo.updateStock(stock.getId(), stock.getName(), stock.getCategory(), stock.getActualPrice(), stock.getDiscountedPrice(), stock.getDescription());
        SizeRequest sizeRequest = stock.getSizes();
        this.sizeRepo.updateSize(sizeRequest.getId(), sizeRequest.getSmall(), sizeRequest.getMedium(), sizeRequest.getLarge(), sizeRequest.getXlarge(), sizeRequest.getXxlarge());
    }
}
