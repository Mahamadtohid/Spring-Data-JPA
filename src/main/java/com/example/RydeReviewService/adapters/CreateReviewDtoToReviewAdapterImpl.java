package com.example.RydeReviewService.adapters;

import com.example.RydeReviewService.controllers.dtos.CreateReviewDto;
import com.example.RydeReviewService.models.Booking;
import com.example.RydeReviewService.models.Review;
import com.example.RydeReviewService.repositories.BookingRepository;
import com.example.RydeReviewService.controllers.dtos.CreateReviewDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter{

    private BookingRepository bookingRepository;



    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto){
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());
        if(booking.isEmpty()) return null;

        return Review.builder()
                .rating(createReviewDto.getRating())
                .content(createReviewDto.getContent())
                .build();
    }
}
