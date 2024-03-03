package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.ProductDto;
import com.architecture.Liquor.Store.entity.Product;
import com.architecture.Liquor.Store.exception.ProductNotFoundException;
import com.architecture.Liquor.Store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int pid) {
        return productRepository.findById(pid)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + pid + " not found"));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        mapDtoToEntity(productDto, product);
        return productRepository.save(product);
    }

    public Product updateProduct(int pid, ProductDto productDto) {
        Product existingProduct = getProductById(pid);
        mapDtoToEntity(productDto, existingProduct);
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int pid) {
        productRepository.deleteById(pid);
    }

    private void mapDtoToEntity(ProductDto productDto, Product product) {
        product.setPname(productDto.getPname());
        product.setPrice(productDto.getPrice());
    }
}
