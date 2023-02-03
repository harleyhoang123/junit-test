package com.example.junit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author : Hoang Lam
 * @product : Merchant-Service
 * @project : VDS
 * @created : 03/02/2023 - 14:57
 * @contact : 0834481768 - lam.hoangvan@apuscorp.com
 **/
@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {

    @Id
    private String paymentId;
    private BigDecimal originalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId) && originalPrice.equals(payment.getOriginalPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, originalPrice);
    }
}
