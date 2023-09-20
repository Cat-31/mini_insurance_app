package com.insurance.life.product.service.strategy.premium;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringJoiner;

public class PremiumCalculateRequest implements Serializable {
    private String productId;
    private int age;
    private String paymentType;
    private String gender;
    private String term;
    private BigDecimal amount;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PremiumCalculateRequest.class.getSimpleName() + "[", "]")
                .add("productId='" + productId + "'")
                .add("age='" + age + "'")
                .add("paymentType='" + paymentType + "'")
                .add("gender='" + gender + "'")
                .add("term='" + term + "'")
                .add("amount=" + amount)
                .toString();
    }
}
