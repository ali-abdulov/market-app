package com.ali.marketapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DummyProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String category;

}