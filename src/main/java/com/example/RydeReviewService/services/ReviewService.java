package com.example.RydeReviewService.services;

import com.example.RydeReviewService.models.Booking;
import com.example.RydeReviewService.repositories.BookingRepository;
import com.example.RydeReviewService.models.Review;
import com.example.RydeReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
//import

@Service
public class ReviewService implements CommandLineRunner{

    private ReviewRepository reviewRepository;

    private BookingRepository bookingRepository;

    public ReviewService(BookingRepository bookingRepository , ReviewRepository reviewRepository){
        this.bookingRepository = bookingRepository;
        this.reviewRepository = reviewRepository;
    }



    @Override
    public void run(String... args) throws Exception{
        Review r =Review.builder()
                .content("Amezing")
                .rating(5.0)
                .build();


        Booking b = Booking
                .builder()
                .review(r)
                .endTime(new Date())
                .build();


//        Review newReview = reviewRepository.save(r);
        bookingRepository.save(b);

//        System.out.println(newReview.toString());
    }

    public void printAllReviews(){
        List<Review> reviews = reviewRepository.findAll();

        for(Review review :reviews){
            System.out.println(review.getContent());
        }
    }

}
