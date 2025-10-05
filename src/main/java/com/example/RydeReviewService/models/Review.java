package com.example.RydeReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder //Apples the builder pattern to create an object of An class Review
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bookingreview")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private double rating;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false)
    private Booking booking; // Defined a 1 : 1 relationship between booking and review

}
