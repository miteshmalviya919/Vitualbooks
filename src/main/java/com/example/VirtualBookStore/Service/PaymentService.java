package com.example.VirtualBookStore.Service;

import com.example.VirtualBookStore.Entity.Payment;
import com.razorpay.Order;
import com.example.VirtualBookStore.Repository.PaymentRepository;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Service
public class PaymentService {

    @Value("${razorpay.key}")
    private String razorpayKey;

    @Value("${razorpay.secret}")
    private String razorpaySecret;


    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }

    public String  makePayment(double amount) throws  RazorpayException  {

        RazorpayClient client = new RazorpayClient (razorpayKey, razorpaySecret);

        JSONObject options = new JSONObject();
        options.put("amount", amount * 100); // amount in paise
        options.put("currency", "INR");
        options.put("receipt", "txn_" + System.currentTimeMillis());

        Order order = client.orders.create(options);

        return order.get("id");





    }

    public boolean verifyPayment(String razorpayOrderId,
                                 String razorpayPaymentId,
                                 String razorpaySignature) {


//        try {
//            String payload = razorpayOrderId + "|" + razorpayPaymentId;
//
//            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
//            SecretKeySpec secretKey =
//                    new SecretKeySpec(razorpaySecret.getBytes(), "HmacSHA256");
//
//            sha256_HMAC.init(secretKey);
//
//            byte[] hash = sha256_HMAC.doFinal(payload.getBytes());
//
//            String generatedSignature =
//                    org.apache.commons.codec.binary.Hex.encodeHexString(hash);
//
//            return generatedSignature.equals(razorpaySignature);
//
//        }

        return true;

    }


    public void makePaymentSuccess(String razorpayOrderId,
                                   String razorpayPaymentId) {

        // TODO:
        // 1. Find order by razorpayOrderId
        // 2. Set status = PAID
        // 3. Save to database

        System.out.println("Payment successful for Order: " + razorpayOrderId);
    }






    public Payment getPayment(Long id) {

        return paymentRepository.findById(id).orElseThrow();
    }



}
