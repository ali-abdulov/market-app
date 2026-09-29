package com.ali.marketapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class MarketProductResponseDto {
    private Long productId;
    private String productName;
    private String categoryName;
    private BigDecimal finalPrice;
}