package com.insurance.life.product.dto;


import com.insurance.life.product.enums.PaymentType;
import com.insurance.life.product.enums.Term;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ConfigDTO implements Serializable {
    private BigDecimal minAmount;

    private int minAge;
    private int maxAge;
    private String premiumCalculateStrategyName;

    private List<Term> supportedTerm;

    private List<PaymentType> paymentTypes;

    public List<Term> getSupportedTerm() {
        return supportedTerm;
    }

    public String getPremiumCalculateStrategyName() {
        return premiumCalculateStrategyName;
    }

    public List<PaymentType> getSupportedPaymentType() {
        return paymentTypes;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public List<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void setPremiumCalculateStrategyName(String premiumCalculateStrategyName) {
        this.premiumCalculateStrategyName = premiumCalculateStrategyName;
    }

    public void setSupportedTerm(List<Term> supportedTerm) {
        this.supportedTerm = supportedTerm;
    }

    public void setPaymentTypes(List<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }
}
