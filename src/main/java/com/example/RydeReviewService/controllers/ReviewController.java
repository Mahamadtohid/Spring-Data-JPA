package com.example.RydeReviewService.controllers;

import com.example.RydeReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.example.RydeReviewService.controllers.dtos.CreateReviewDto;
import com.example.RydeReviewService.models.Review;
import com.example.RydeReviewService.repositories.ReviewRepository;
import com.example.RydeReviewService.services.ReviewServiceImp;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    ReviewRepository reviewRepository;

    ReviewServiceImp reviewService;

    ReviewController(ReviewRepository reviewRepository ,ReviewServiceImp reviewService , CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter){
        this.reviewRepository = reviewRepository;
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @GetMapping
    public List<Review> getAllReviews(){

        return reviewService.getAllReviews();
    }

    @GetMapping("/{reviewId}")
    public Review getReview(@PathVariable("reviewId") Long id){
            Review myReview = reviewService.getReview(id);
        return myReview;
    }

    @PostMapping()
    @Transactional(readOnly = true)
    public ResponseEntity<?> createNewReview(@Validated @RequestBody CreateReviewDto review){

        Review inCommingReview = createReviewDtoToReviewAdapter.convertDto(review);
        if(inCommingReview == null) {
            return new ResponseEntity<>("Invalid Arguments" , HttpStatus.BAD_REQUEST);
        }

        Review newReview = reviewService.createReview(inCommingReview);


        /* ReviewDto response = ReviewDto.builder().id(review.getId()). ------- and soon the 2nd way to give response using DTO layer
        * */

        return new ResponseEntity<>(newReview , HttpStatus.OK);

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



}
