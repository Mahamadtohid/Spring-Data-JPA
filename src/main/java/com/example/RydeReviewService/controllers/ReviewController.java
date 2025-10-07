package com.example.RydeReviewService.controllers;

import com.example.RydeReviewService.models.Review;
import com.example.RydeReviewService.repositories.ReviewRepository;
import com.example.RydeReviewService.services.ReviewServiceImp;
import jakarta.websocket.server.PathParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    ReviewRepository reviewRepository;

    ReviewServiceImp reviewService;

    ReviewController(ReviewRepository reviewRepository ,ReviewServiceImp reviewService){
        this.reviewRepository = reviewRepository;
        this.reviewService = reviewService;
    }

    @GetMapping("/{reviewId}")
    public Review getReview(@PathVariable("reviewId") Long id){
            Review myReview = reviewService.getReview(id);
        return myReview;
    }

    @PostMapping()
    public Review createNewReview(@RequestBody Review review){

        Review newReview = reviewService.createReview(review);

        return newReview;

    }

    @GetMapping("/booking/{bookingId}")
    public Review getReviewByBooking(@PathVariable("bookingId") Long id){
        Review myReview = reviewService.getReviewByBooking(id);
        return myReview;
    }

    @DeleteMapping("/{reviewId}")
    public boolean deleteReview(@PathVariable("reviewId") Long id){

//        if(reviewService.deleteReviewByBooking(id)) return true;
        try{
            reviewService.deleteReviewByBooking(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

//        return false;
    }

    @DeleteMapping("/booking/{bookingId}")
    public boolean deleteReviewByBooking(@PathVariable("bookingId") Long id){
        try{
            reviewService.deleteReviewByBooking(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }



//    @GetMapping
//    public String getMsg(){
//        return "Haa bhai sab thik chal ra hai.... baki API's try karle";
//    }




}
