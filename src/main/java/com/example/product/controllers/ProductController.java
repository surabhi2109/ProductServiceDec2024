package com.example.product.controllers;

import com.example.product.models.Product;
import com.example.product.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/serviceName")
    public String service(){
        return "Products";
    }

    @GetMapping("/{id}")
    public Product getProducts(@PathVariable long id){
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("{id}")
    public Product deleteProduct(@PathVariable long id){
        return productService.deleteProductById(id);
    }
}
