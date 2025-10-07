package com.example.RydeReviewService.services;


import com.example.RydeReviewService.models.Review;
import com.example.RydeReviewService.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService{

    ReviewRepository reviewRepository;

    ReviewServiceImp(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getReview(Long id) {

        return reviewRepository.findReviewById(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteReviewByBooking(Long id){
        reviewRepository.deleteByBookingId(id);
    }

    @Override
    public Review createReview(Review review) {

        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewByBooking(Long id){

        return reviewRepository.findReviewByBookingId(id);
    }

//    @Override
//    public Review updateReview(Review review) {
//
//        return reviewRepository.createReview(review);
//    }

}
