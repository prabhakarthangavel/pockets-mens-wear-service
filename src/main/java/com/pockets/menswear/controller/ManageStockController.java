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
        try {
            this.stockService.createStock(createStockRequest);
            return ResponseEntity.ok().body(new Response("created"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }

    @PostMapping("/editStock")
    public ResponseEntity<Response> editStock(@RequestBody final ProductRequest editStockRequest) {
        try {
            this.stockService.editStock(editStockRequest);
            return ResponseEntity.ok().body(new Response("updated"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }

    @DeleteMapping("/deleteStock/{id}")
    public ResponseEntity<Response> deleteStock(@PathVariable final long id) {
        try {
            this.stockService.deleteStock(id);
            return ResponseEntity.ok().body(new Response("deleted"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
        }
    }
}
