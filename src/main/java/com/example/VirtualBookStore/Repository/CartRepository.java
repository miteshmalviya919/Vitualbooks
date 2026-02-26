package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {


   //   List<CartItem> findByUserId(Long U)
    List<CartItem> findByUserId(Long userId);

}
