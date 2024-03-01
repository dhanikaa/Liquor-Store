package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.CartDto;
import com.architecture.Liquor.Store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/cart")
@CrossOrigin
public class CartController {


    @Autowired
    private CartService cartService;
    @PostMapping("/saveCder")
    public CartDto saveOder(@RequestBody CartDto cartDto) {

        return cartService.saveCartItems(cartDto);


    }


    @GetMapping("/getCartItems")
    public List<CartDto> getCartItems() {
        return cartService.getAllCartItems();
    }


    @PutMapping("/updateCartItems")
    public String updateOders(@RequestBody CartDto cartDto){
        cartService.updateCartItems(cartDto);
        return "Oder Updated";
    }

    @DeleteMapping("/deleteCartItems")
    public String deleteCartItens(@RequestBody CartDto cartDto){
        cartService.deleteCartItems(cartDto);
        return "delete succesfully";
    }

}
