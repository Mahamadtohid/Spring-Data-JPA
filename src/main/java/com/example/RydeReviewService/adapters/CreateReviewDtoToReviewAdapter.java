package com.example.RydeReviewService.adapters;

import com.example.RydeReviewService.controllers.dtos.CreateReviewDto;
import com.example.RydeReviewService.models.Review;

public interface CreateReviewDtoToReviewAdapter {

    public Review convertDto(CreateReviewDto createReviewDto);
}
