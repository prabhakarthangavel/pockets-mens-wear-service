package com.pockets.menswear.controller;

import com.pockets.menswear.request.ProductRequest;
import com.pockets.menswear.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/fetchProduct/{category}")
    public ResponseEntity<List<ProductRequest>> getProducts(@PathVariable final String category) {
        return ResponseEntity.ok().body(this.productsService.getProducts(category));
    }
}
