package com.example.RydeReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NonNull;

@Entity
public class Review {

    @Id
    Long id;
}
