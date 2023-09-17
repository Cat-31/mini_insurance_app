package com.insurance.life.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.StringJoiner;

@Entity
public class Rate {
    @Id
    @GeneratedValue
    private Long id;

    private String productId;
    private int age;
    private String gender;

    @Column(scale = 6, precision = 8)
    private BigDecimal rate;

    public Rate() {
    }

    public Rate(String productId, int age, String gender, BigDecimal rate) {
        this.productId = productId;
        this.age = age;
        this.gender = gender;
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Rate.class.getSimpleName() + "[", "]")
                .add("productId='" + productId + "'")
                .add("age=" + age)
                .add("gender='" + gender + "'")
                .add("rate=" + rate)
                .toString();
    }
}
