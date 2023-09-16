package com.insurance.life.product.entity;

import com.insurance.life.product.common.PaymentType;
import com.insurance.life.product.common.Term;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Config implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal minAmount;

    private int minAge;
    private int maxAge;

    @Enumerated(EnumType.STRING)
    private List<Term> supportedTerm;

    @Enumerated(EnumType.STRING)
    private List<PaymentType> paymentTypes;

    public Config() {
    }

    public Config(int minAge, int maxAge,BigDecimal minAmount,
                  List<Term> supportedTerm, List<PaymentType> paymentTypes) {
        this.minAmount = minAmount;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.supportedTerm = supportedTerm;
        this.paymentTypes = paymentTypes;
    }

    public List<Term> getSupportedTerm() {
        return supportedTerm;
    }
}