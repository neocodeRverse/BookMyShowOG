package com.raghuveer.BookMyShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    //private Long customerId;
    @ManyToOne
    @JoinColumn(name = "id")
    private customer customer;

    //private String movieName;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private owner owner;

    private Integer seatsRequired;
    private Integer ticketPrice;
    private Integer totalPrice;
    private String paymentStatus;
    
}


