package com.ali.marketapp.controller;

import com.ali.marketapp.dto.DummyProductResponseDto;
import com.ali.marketapp.entity.Product;
import com.ali.marketapp.service.MarketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(marketService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(marketService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(marketService.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(marketService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        marketService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/product/{id}")
    public DummyProductResponseDto getProductSync(@PathVariable Long id) {
        return marketService.getProductSync(id);
    }

    @GetMapping("/async-product/{id}")
    public CompletableFuture<DummyProductResponseDto> getProductAsync(@PathVariable Long id) {
        return marketService.getProductAsync(id);
    }
}