package com.example.RydeReviewService.services;

import com.example.RydeReviewService.models.Review;

import java.util.List;

public interface ReviewService {

    public Review getReview(Long id);

    public List<Review> getAllReviews();

    public Review createReview(Review review);

    public Review getReviewByBooking(Long id);

    public void deleteReview(Long id);

    public void deleteReviewByBooking(Long id);

//    public Review updateReview(Review review);
}
