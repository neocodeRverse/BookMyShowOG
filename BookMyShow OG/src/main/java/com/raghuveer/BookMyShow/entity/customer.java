package com.raghuveer.BookMyShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class customer {
   @Id
   @GeneratedValue
    private Long id;
    private String customerName;
    private String customerCity;
    private String movieName;
    private String movieTiming;
    private Integer seatsRequired;

}
