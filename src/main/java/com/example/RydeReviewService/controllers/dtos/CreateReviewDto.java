package com.example.RydeReviewService.controllers.dtos;

import com.example.RydeReviewService.models.Review;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto{
    private String content;

    private double rating;

    private Long bookingId;
}
