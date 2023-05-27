package com.torres.springsecurity3demo.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Integer id;
    private String name;
    private Integer qty;
    private Integer price;
}
