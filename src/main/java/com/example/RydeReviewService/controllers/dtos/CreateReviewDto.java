package com.example.RydeReviewService.controllers.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto {
    private String content;

    private double rating;

    private long bookingId;
}
