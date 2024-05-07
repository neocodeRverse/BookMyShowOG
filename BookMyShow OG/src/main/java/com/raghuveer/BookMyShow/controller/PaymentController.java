package com.raghuveer.BookMyShow.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghuveer.BookMyShow.entity.Payment;
import com.raghuveer.BookMyShow.service.PaymentService;

@RestController
@RequestMapping("/bms/owner/payment")
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.savePayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            return ResponseEntity.ok(payment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
    Optional<Payment> existingPayment = paymentService.getPaymentById(id);
    if (existingPayment.isPresent()) {
        updatedPayment.setPaymentId(id);
        Payment savedPayment = paymentService.savePayment(updatedPayment);
        return ResponseEntity.ok(savedPayment);
    } else {
        return ResponseEntity.notFound().build();
    }
    }

    @DeleteMapping("/{id}")
    public void deleteowner (@PathVariable("id") Long id){
        paymentService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<Iterable<Payment>> getAllPayments() {
        Iterable<Payment> payments = paymentService.findAll();
        if (payments.iterator().hasNext()) {
            return ResponseEntity.ok(payments);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
}


