package com.example.RydeReviewService.repositories;

import com.example.RydeReviewService.models.Booking;
import com.example.RydeReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long Id , String licenceNuber);
}
