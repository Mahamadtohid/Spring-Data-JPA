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
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private double rating;

}
