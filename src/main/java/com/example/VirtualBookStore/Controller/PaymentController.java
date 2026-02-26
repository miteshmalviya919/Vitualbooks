package com.example.VirtualBookStore.Controller;

import com.example.VirtualBookStore.Entity.Payment;
import com.example.VirtualBookStore.Service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("Payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/Pay")
    public String makePayment(double amount) throws RazorpayException {
        return paymentService.makePayment( amount);
    }


    @PostMapping("/verify")
    public String verifyPayment(
            @RequestParam String razorpayOrderId,
            @RequestParam String razorpayPaymentId,
            @RequestParam String razorpaySignature) {

        boolean isValid = paymentService.verifyPayment(
                razorpayOrderId,
                razorpayPaymentId,
                razorpaySignature
        );

        if (isValid) {
            paymentService.makePaymentSuccess(
                    razorpayOrderId,
                    razorpayPaymentId
            );
            return "Payment verified and marked as PAID";
        } else {
            return "Payment verification failed";
        }
    }







        @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }

}