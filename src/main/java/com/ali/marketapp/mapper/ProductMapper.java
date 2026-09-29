package com.ali.marketapp.mapper;

import com.ali.marketapp.dto.DummyProductResponseDto;
import com.ali.marketapp.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(DummyProductResponseDto dummyDto) {
        if (dummyDto == null) {
            return null;
        }

        return new Product(
                dummyDto.getId(),
                dummyDto.getTitle(),
                dummyDto.getCategory(),
                dummyDto.getPrice()
        );
    }
}