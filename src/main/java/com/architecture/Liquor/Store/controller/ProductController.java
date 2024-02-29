package com.architecture.Liquor.Store.controller;


import com.architecture.Liquor.Store.dto.ProductDto;
import com.architecture.Liquor.Store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct")
    public String getProduct(){

        return "Product Created";
    }

    @PostMapping("/saveProduct")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct(productDto);
    }

    @PutMapping("/updateProduct")
    public String updateProduct(){

        return "Product Updated";
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(){

        return "Product delete";
    }



}
