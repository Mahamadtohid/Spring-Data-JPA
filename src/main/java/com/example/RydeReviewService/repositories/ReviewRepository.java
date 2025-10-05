package com.example.RydeReviewService.repositories;


import com.example.RydeReviewService.models.Driver;
import com.example.RydeReviewService.models.Passenger;
import com.example.RydeReviewService.models.PassengerReview;
import com.example.RydeReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThan(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date givenDate);

    @Query("SELECT r from Booking b join Review r on b.review = r where b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);

//    @Query("select new com.example.rydereviewservice.repositories() from Booking b join Passenger p join Driver d")
//    Custom findDriverPassengerReviewByBookingId(Long bookingId);
}

//class Custom{
//
//    public Review review;
//
//    public Passenger passenger;
//
//    public Driver driver;
//
//    public custom(Review review , Passenger passenger , Driver driver){
//
//        this.passenger = passenger;
//        this.driver = driver;
//        this.review=review;
//
//    }
//}
