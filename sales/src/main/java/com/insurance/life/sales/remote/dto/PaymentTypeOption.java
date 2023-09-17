package com.insurance.life.sales.remote.dto;

import java.io.Serializable;

public class PaymentTypeOption implements Serializable {

    private String paymentType;
    private String description;

    public PaymentTypeOption(String paymentType, String description) {
        this.paymentType = paymentType;
        this.description = description;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getDescription() {
        return description;
    }
}
