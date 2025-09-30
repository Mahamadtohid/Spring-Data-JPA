package com.example.RydeReviewService.services;

import com.example.RydeReviewService.models.Booking;
import com.example.RydeReviewService.models.Driver;
import com.example.RydeReviewService.repositories.BookingRepository;
import com.example.RydeReviewService.models.Review;
import com.example.RydeReviewService.repositories.DriverRepository;
import com.example.RydeReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
//import

@Service
public class ReviewService implements CommandLineRunner{

    private ReviewRepository reviewRepository;

    private BookingRepository bookingRepository;

    private DriverRepository driverRepository;

    public ReviewService(BookingRepository bookingRepository , ReviewRepository reviewRepository , DriverRepository driverRepository){
        this.bookingRepository = bookingRepository;
        this.reviewRepository = reviewRepository;
        this.driverRepository = driverRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("***********************************************************************");

        //        Review r =Review.builder()
//                .content("Amezing")
//                .rating(5.0)
//                .build();
//
//
//        Booking b = Booking
//                .builder()
//                .review(r)
//                .endTime(new Date())
//                .build();
//
//
//        Review newReview = reviewRepository.save(r);
//        bookingRepository.save(b);
//
//        System.out.println(newReview.toString());
//    }
//
//    public void printAllReviews(){
//        List<Review> reviews = reviewRepository.findAll();
//
//        for(Review review :reviews){
//            System.out.println(review.getContent());
//        }
//    }
        Optional<Driver> drivers = driverRepository.findByIdAndLicenseNumber(1L , "MH093318");

        System.out.println(drivers);

        if(drivers.isPresent()){
            System.out.println(drivers.get().getName());
        }

    }


}
