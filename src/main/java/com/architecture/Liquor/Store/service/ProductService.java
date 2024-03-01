package com.architecture.Liquor.Store.service;


import com.architecture.Liquor.Store.dto.ProductDto;
import com.architecture.Liquor.Store.entity.Product;
import com.architecture.Liquor.Store.repository.ProductRepositoty;
import com.architecture.Liquor.Store.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepositoty productRepository;
    @Autowired
    private ModelMapper modelMapper;
    public ProductDto saveProduct(ProductDto productDto){
        productRepository.save(modelMapper.map(productDto, Product.class));
        return productDto;
    }



    public List<ProductDto> getAllProducts() {
        List<Product>productList=productRepository.findAll();
        return modelMapper.map(productList, new TypeToken <List <ProductDto>>(){}.getType());

    }
}
