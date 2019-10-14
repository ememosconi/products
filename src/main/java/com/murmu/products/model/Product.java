package com.murmu.products.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Long price;
    private String description;
}
