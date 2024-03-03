package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.CartDto;
import com.architecture.Liquor.Store.entity.Cart;
import com.architecture.Liquor.Store.exception.CartNotFoundException;
import com.architecture.Liquor.Store.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(int cid) {
        return cartRepository.findById(cid)
                .orElseThrow(() -> new CartNotFoundException("Cart with id " + cid + " not found"));
    }

    public Cart createCart(CartDto cartDto) {
        Cart cart = new Cart();
        mapDtoToEntity(cartDto, cart);
        return cartRepository.save(cart);
    }

    public Cart updateCart(int cid, CartDto cartDto) {
        Cart existingCart = getCartById(cid);
        mapDtoToEntity(cartDto, existingCart);
        return cartRepository.save(existingCart);
    }

    public void deleteCart(int cid) {
        cartRepository.deleteById(cid);
    }

    private void mapDtoToEntity(CartDto cartDto, Cart cart) {
        cart.setPid(cartDto.getPid());
        cart.setQuantity(cartDto.getQuantity());
        cart.setPrice(cartDto.getPrice());
    }
}
