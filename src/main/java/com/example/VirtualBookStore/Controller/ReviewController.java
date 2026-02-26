package com.example.VirtualBookStore.Controller;

import com.example.VirtualBookStore.Entity.Review;
import com.example.VirtualBookStore.Service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Rev")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @GetMapping("/book/{bookId}")
    public List<Review> getReviewsByBook(@PathVariable Long bookId) {
        return reviewService.getReviewsByBook(bookId);
    }

}
