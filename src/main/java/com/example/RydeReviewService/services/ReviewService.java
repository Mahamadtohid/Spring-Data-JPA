package com.example.RydeReviewService.services;

import com.example.RydeReviewService.models.Review;

import java.util.List;

public interface ReviewService {

    public Review getReview(Long id);

    public List<Review> getAllReviews();

    public boolean deleteReview(Long id);

    public Review createReview(Review review);

    public Review updateReview(Review review);
}
