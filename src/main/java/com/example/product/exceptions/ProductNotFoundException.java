package com.example.product.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends ProductException {
    private final long id;

    public ProductNotFoundException(long id,long productId) {
        super(String.format("Product with ID %d not found",productId));
        this.id = id;
    }
}
