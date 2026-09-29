package com.ali.marketapp.service;

import com.ali.marketapp.client.ProductClient;
import com.ali.marketapp.dto.DummyProductResponseDto;
import com.ali.marketapp.entity.Product;
import com.ali.marketapp.exception.ResourceNotFoundException;
import com.ali.marketapp.repository.ProductRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class MarketService {

    private final ProductRepository productRepository;
    private final ProductClient productClient;

    public MarketService(ProductRepository productRepository, ProductClient productClient) {
        this.productRepository = productRepository;
        this.productClient = productClient;
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product request) {
        Product existing = getProductById(id);
        existing.setName(request.getName());
        existing.setCategory(request.getCategory());
        existing.setPrice(request.getPrice());
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        productRepository.delete(existing);
    }



    public DummyProductResponseDto getProductSync(Long id) {
        return productClient.getProductById(id);
    }

    @Async
    public CompletableFuture<DummyProductResponseDto> getProductAsync(Long id) {
        DummyProductResponseDto dummyProduct = productClient.getProductById(id);
        return CompletableFuture.completedFuture(dummyProduct);
    }
}