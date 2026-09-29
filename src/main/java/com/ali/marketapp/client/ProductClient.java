package com.ali.marketapp.client;

import com.ali.marketapp.dto.DummyProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dummy-product-client", url = "https://dummyjson.com")
public interface ProductClient {

    @GetMapping("/products/{id}")
    DummyProductResponseDto getProductById(@PathVariable Long id);
}