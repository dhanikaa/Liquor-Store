package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.ProductDto;
import com.architecture.Liquor.Store.entity.Product;
import com.architecture.Liquor.Store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{pid}")
    public ResponseEntity<Product> getProductById(@PathVariable int pid) {
        Product product = productService.getProductById(pid);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        Product createdProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{pid}")
    public ResponseEntity<Product> updateProduct(@PathVariable int pid, @RequestBody ProductDto productDto) {
        Product updatedProduct = productService.updateProduct(pid, productDto);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int pid) {
        productService.deleteProduct(pid);
        return ResponseEntity.noContent().build();
    }
}
