package com.example.RydeReviewService.controllers.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Long id;

    private String content;

    private Double rating;

    private Long booking;

}
