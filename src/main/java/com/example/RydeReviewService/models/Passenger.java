package com.example.RydeReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel{

    private String name;

//    private String passengerId;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> booking = new ArrayList<>();
}
