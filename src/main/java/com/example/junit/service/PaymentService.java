package com.example.junit.service;

import com.example.junit.entity.Payment;

import java.math.BigDecimal;

/**
 * @author : Hoang Lam
 * @product : Merchant-Service
 * @project : VDS
 * @created : 03/02/2023 - 14:50
 * @contact : 0834481768 - lam.hoangvan@apuscorp.com
 **/
public interface PaymentService {

    void tryToCreatePayment(Payment payment);

    BigDecimal calculateDiscountedPrice(BigDecimal originalPrice, BigDecimal discount);
}
