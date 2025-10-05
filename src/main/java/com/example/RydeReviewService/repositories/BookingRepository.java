package com.example.RydeReviewService.repositories;

import com.example.RydeReviewService.models.Booking;
import com.example.RydeReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

    List<Booking> findAllByDriverId(Long driverId);


}
