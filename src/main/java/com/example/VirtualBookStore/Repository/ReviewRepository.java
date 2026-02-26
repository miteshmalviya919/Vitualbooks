package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Entity.Order;
import com.example.VirtualBookStore.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByBookId(Long bookId);
}
