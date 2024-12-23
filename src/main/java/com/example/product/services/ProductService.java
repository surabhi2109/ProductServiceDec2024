package com.example.product.services;

import com.example.product.exceptions.ProductNotFoundException;
import com.example.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getProductById(long id) throws ProductNotFoundException;

    List<Product> getProducts();

    Product saveProduct(Product product);

    void deleteProductById(long id) throws ProductNotFoundException;

    Product updateProduct(long id, Product product);

    Product patchProduct(long id, Product product);
}
