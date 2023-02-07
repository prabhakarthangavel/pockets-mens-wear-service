package com.pockets.menswear.controller;

import com.pockets.menswear.request.CartRequest;
import com.pockets.menswear.request.ProductRequest;
import com.pockets.menswear.response.Response;
import com.pockets.menswear.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/fetchProduct")
    public ResponseEntity<?> getAllProducts() {
        List<ProductRequest> productList = this.productsService.getAllProducts();
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/fetchProduct/{category}")
    public ResponseEntity<?> getProducts(@PathVariable final String category) {
        List<ProductRequest> productList = this.productsService.getProducts(category);
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/productDetail/{id}")
    public ResponseEntity<?> getProductDetail(@PathVariable final long id) {
        try {
            return ResponseEntity.ok().body(this.productsService.getProductDetail(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }

    @GetMapping("/topDeals")
    public ResponseEntity<?> getTopDeals() {
        try {
            return ResponseEntity.ok().body(this.productsService.getTopDeals());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }

    @PostMapping("/addCart")
    public ResponseEntity<?> addToCart(@RequestBody CartRequest cartRequest) {
        try {
            this.productsService.addToCart(cartRequest);
            return ResponseEntity.ok().body(new Response("added"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }

    @GetMapping("/fetchCart")
    public ResponseEntity<?> fetchCart() {
        try {
            return ResponseEntity.ok().body(this.productsService.fetchCartItems());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }

    @GetMapping("/fetchCartDetail")
    public ResponseEntity<?> fetchCartDetail() {
        try {
            return ResponseEntity.ok().body(this.productsService.fetchCartItemsDetail());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }

    @DeleteMapping("/removeCartItem")
    public ResponseEntity<?> deleteItem(@RequestParam final long productId) {
        try {
            return ResponseEntity.ok().body(this.productsService.deleteCartItem(productId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }
}
