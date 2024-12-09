package com.example.product.services;

import com.example.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getProductById(long id);

    List<Product> getProducts();

    Product saveProduct(Product product);

    Product deleteProductById(long id);

    Product updateProduct(long id, Product product);
}
