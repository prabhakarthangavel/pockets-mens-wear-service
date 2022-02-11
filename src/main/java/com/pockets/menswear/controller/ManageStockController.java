package com.pockets.menswear.controller;

import com.pockets.menswear.request.CreateStockRequest;
import com.pockets.menswear.response.Response;
import com.pockets.menswear.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manageStock")
public class ManageStockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/hello")
    public ResponseEntity<Response> sayHello() {
        return ResponseEntity.ok().body(new Response("hello world"));
    }

    @PostMapping("/createStock")
    public ResponseEntity<Response> createStock(@RequestBody final CreateStockRequest createStockRequest) {
        this.stockService.createStock(createStockRequest);
        return ResponseEntity.ok().body(new Response("created"));
    }
}
