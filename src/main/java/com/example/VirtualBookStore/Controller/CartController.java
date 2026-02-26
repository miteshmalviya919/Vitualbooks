package com.example.VirtualBookStore.Controller;

import com.example.VirtualBookStore.Entity.CartItem;
import com.example.VirtualBookStore.Service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CartController")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem cartItem) {
        return cartService.addToCart(cartItem);
    }

    @GetMapping("/user/{userId}")
    public List<CartItem> getCartByUser(@PathVariable Long userId) {
        return cartService.getCartByUser(userId);
    }



}
