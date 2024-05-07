package com.raghuveer.BookMyShow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghuveer.BookMyShow.entity.Payment;
import com.raghuveer.BookMyShow.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPaymentById(Long id){
        return paymentRepository.findById(id);
    }

    public Iterable<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public void deleteById(final Long aLong){
        paymentRepository.deleteById(aLong);
    }

}
