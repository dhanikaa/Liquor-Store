package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.CartDto;
import com.architecture.Liquor.Store.entity.Cart;
import com.architecture.Liquor.Store.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CartDto saveCartItems(CartDto cartDto) {
        cartRepository.save(modelMapper.map(cartDto, Cart.class));

        return cartDto;

    }

    public List<CartDto>getAllCartItems() {

        List<Cart>cartList= cartRepository.findAll();
        return modelMapper.map(cartList,new TypeToken<List<CartDto>>(){}.getType());
    }

    public CartDto updateCartItems(CartDto cartDto) {
        cartRepository.save(modelMapper.map(cartDto, Cart.class));

        return cartDto;
    }

    public boolean deleteCartItems(CartDto cartDto) {
       cartRepository.delete(modelMapper.map(cartDto, Cart.class));
        return true;

    }

}