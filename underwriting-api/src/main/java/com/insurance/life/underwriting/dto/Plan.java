package com.insurance.life.underwriting.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringJoiner;

public class Plan implements Serializable {
    private String productId;
    private String term;
    private BigDecimal amount;
    private BigDecimal premium;

    public Plan(String productId, String term, BigDecimal amount, BigDecimal premium) {
        this.productId = productId;
        this.term = term;
        this.amount = amount;
        this.premium = premium;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Plan.class.getSimpleName() + "[", "]")
                .add("productId='" + productId + "'")
                .add("term='" + term + "'")
                .add("amount=" + amount)
                .add("premium=" + premium)
                .toString();
    }
}
