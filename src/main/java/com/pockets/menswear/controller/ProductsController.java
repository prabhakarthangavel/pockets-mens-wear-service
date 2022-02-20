package com.pockets.menswear.controller;

import com.pockets.menswear.request.ProductRequest;
import com.pockets.menswear.response.Response;
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
    public ResponseEntity<?> getProducts(@PathVariable final String category) {
        List<ProductRequest> productList = this.productsService.getProducts(category);
        if (productList.isEmpty()) {
            return ResponseEntity.badRequest().body(new Response("Product Not Found"));
        }
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/productDetail/{id}")
    public ResponseEntity<?> getProductDetail(@PathVariable final long id) {
        try {
            return ResponseEntity.ok().body(this.productsService.getProductDetail(id));
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }
}
