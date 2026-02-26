package com.example.VirtualBookStore.Service;

import com.example.VirtualBookStore.Entity.Review;
import com.example.VirtualBookStore.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByBook(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }



}
