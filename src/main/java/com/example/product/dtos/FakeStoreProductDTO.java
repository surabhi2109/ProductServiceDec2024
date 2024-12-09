package com.example.product.dtos;

import com.example.product.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
