package com.example.product.exceptionhnadlers;

import com.example.product.dtos.ProductNotFoundExceptionDto;
import com.example.product.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException exception) {
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setErrorCode(exception.getId());
        dto.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
