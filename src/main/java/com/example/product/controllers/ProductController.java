package com.example.product.controllers;

import com.example.product.exceptions.ProductNotFoundException;
import com.example.product.models.Product;
import com.example.product.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Product> getProductById(@PathVariable long id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product createdProduct = productService.saveProduct(product);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(id,product);
        return ResponseEntity.ok(updatedProduct);
    }

    @PatchMapping("/{id}")
    //Not Working
    public ResponseEntity<Product> patchProduct(@PathVariable Long id, @RequestBody Product product){
        Product updatedProduct = productService.patchProduct(id,product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) throws ProductNotFoundException{
        /*Product deletedProduct = */productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
