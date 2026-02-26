package com.example.VirtualBookStore.Service;

import com.example.VirtualBookStore.Entity.CartItem;
import com.example.VirtualBookStore.Repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {

    private final CartRepository cartItemRepository;

    public CartService(CartRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem addToCart(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartByUser(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

}
