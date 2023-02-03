package com.example.junit.repository;

import com.example.junit.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Hoang Lam
 * @product : Merchant-Service
 * @project : VDS
 * @created : 03/02/2023 - 14:57
 * @contact : 0834481768 - lam.hoangvan@apuscorp.com
 **/
@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
