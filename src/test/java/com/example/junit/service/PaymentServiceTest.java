package com.example.junit.service;

import com.example.junit.entity.Payment;
import com.example.junit.repository.PaymentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Hoang Lam
 * @product : Merchant-Service
 * @project : VDS
 * @created : 03/02/2023 - 14:53
 * @contact : 0834481768 - lam.hoangvan@apuscorp.com
 **/
@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PaymentRepository paymentRepository;

    private Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder()
                .paymentId(UUID.randomUUID().toString())
                .originalPrice(BigDecimal.valueOf(400).setScale(2, RoundingMode.CEILING))
                .build();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateDiscountedPrice() {
        BigDecimal discountedPrice = paymentService.calculateDiscountedPrice(BigDecimal.valueOf(10000), BigDecimal.valueOf(0.3));
        System.out.println(discountedPrice);
    }

    @Test
    void tryToCreatePayment() {
        paymentService.tryToCreatePayment(payment);
        Optional<Payment> paymentOptional = paymentRepository.findById(payment.getPaymentId());
        assertEquals(paymentOptional.get(), payment);
    }
}
