package com.example.VirtualBookStore.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod; // e.g., Stripe, PayPal
    private double amount;
    private Date paymentDate;
    private String status; // SUCCESS, FAILED, PENDING

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String razorpayOrderId;



}
