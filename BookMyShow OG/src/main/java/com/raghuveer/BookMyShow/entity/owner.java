package com.raghuveer.BookMyShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class owner {
    @Id
    @GeneratedValue
    private Long movieId;
    private String movieName;
    private String showTiming;
    private Integer seatsAvailable;
    private Integer ticketPrice;

}
