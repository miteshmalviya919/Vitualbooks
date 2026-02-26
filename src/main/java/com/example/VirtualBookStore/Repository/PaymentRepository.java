package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
