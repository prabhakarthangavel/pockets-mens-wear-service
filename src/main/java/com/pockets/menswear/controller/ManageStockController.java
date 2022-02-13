package com.pockets.menswear.controller;

import com.pockets.menswear.request.ProductRequest;
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

    @PostMapping("/createStock")
    public ResponseEntity<Response> createStock(@RequestBody final ProductRequest createStockRequest) {
        this.stockService.createStock(createStockRequest);
        return ResponseEntity.ok().body(new Response("created"));
    }
}
