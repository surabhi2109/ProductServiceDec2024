package com.example.product.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private Double price;
    private Category category;
    private String description;
}
