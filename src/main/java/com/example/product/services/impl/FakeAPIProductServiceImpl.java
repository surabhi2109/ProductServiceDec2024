package com.example.product.services.impl;

import com.example.product.dtos.FakeStoreProductDTO;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeAPIProductServiceImpl implements ProductService {

    RestTemplate restTemplate;

    FakeAPIProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) {
        FakeStoreProductDTO dto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        return convertToProduct(dto);
    }

    @Override
    public List<Product> getProducts() {
        FakeStoreProductDTO[] objects = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO dto : objects) {
            Product product = convertToProduct(dto);
            products.add(product);

        }
        return products;
    }

    @Override
    public Product saveProduct(Product product) {
        FakeStoreProductDTO dto = convertToDto(product);
        FakeStoreProductDTO savedProduct = restTemplate.postForObject("https://fakestoreapi.com/products", dto, FakeStoreProductDTO.class);
        return convertToProduct(savedProduct);
    }

    @Override
    public Product deleteProductById(long id) {
        Product deletedProduct = getProductById(id);
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        return deletedProduct;
    }

    public Product updateProduct(long id, Product updatedProduct){
        restTemplate.put("https://fakestoreapi.com/products/"+id, updatedProduct);
        updatedProduct.setId(id);
        return updatedProduct;
    }

    private Product convertToProduct(FakeStoreProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        Category category = new Category();
        category.setTitle(dto.getCategory());
        product.setCategory(category);
        product.setDescription(dto.getDescription());
        return product;
    }

    private FakeStoreProductDTO convertToDto(Product product) {
        FakeStoreProductDTO dto = new FakeStoreProductDTO();
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        String category = product.getCategory().getTitle();
        dto.setCategory(category);
        dto.setDescription(product.getDescription());
        return dto;
    }
}
