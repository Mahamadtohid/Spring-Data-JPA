package com.example.RydeReviewService.services;

import com.example.RydeReviewService.models.Review;
import com.example.RydeReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
//import

@Service
public class ReviewService implements CommandLineRunner{

    private ReviewRepository reviewRepository;


    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }


    @Override
    public void run(String... args) throws Exception{
        Review r =Review.builder()
                .content("Amezing")
                .rating(5.0)
                .build();


        Review newReview = reviewRepository.save(r);

        System.out.println(newReview.toString());
    }

    public void printAllReviews(){
        List<Review> reviews = reviewRepository.findAll();

        for(Review review :reviews){
            System.out.println(review.getContent());
        }
    }

}
