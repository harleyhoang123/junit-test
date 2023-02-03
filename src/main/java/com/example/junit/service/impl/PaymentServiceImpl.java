package com.example.junit.service.impl;

import com.example.junit.entity.Payment;
import com.example.junit.repository.PaymentRepository;
import com.example.junit.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : Hoang Lam
 * @product : Merchant-Service
 * @project : VDS
 * @created : 03/02/2023 - 14:50
 * @contact : 0834481768 - lam.hoangvan@apuscorp.com
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public void tryToCreatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public BigDecimal calculateDiscountedPrice(BigDecimal originalPrice, BigDecimal discount) {
        return originalPrice.subtract(originalPrice.multiply(discount).divide(BigDecimal.valueOf(100), 3, RoundingMode.CEILING));
    }
}
