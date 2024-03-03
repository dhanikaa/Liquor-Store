package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.CartDto;
import com.architecture.Liquor.Store.entity.Cart;
import com.architecture.Liquor.Store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{cid}")
    public ResponseEntity<Cart> getCartById(@PathVariable int cid) {
        Cart cart = cartService.getCartById(cid);
        return ResponseEntity.ok(cart);
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartDto cartDto) {
        Cart createdCart = cartService.createCart(cartDto);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    @PutMapping("/{cid}")
    public ResponseEntity<Cart> updateCart(@PathVariable int cid, @RequestBody CartDto cartDto) {
        Cart updatedCart = cartService.updateCart(cid, cartDto);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{cid}")
    public ResponseEntity<Void> deleteCart(@PathVariable int cid) {
        cartService.deleteCart(cid);
        return ResponseEntity.noContent().build();
    }
}
