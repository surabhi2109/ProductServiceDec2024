package com.example.product.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDto {
    long errorCode;
    String errorMessage;
}
