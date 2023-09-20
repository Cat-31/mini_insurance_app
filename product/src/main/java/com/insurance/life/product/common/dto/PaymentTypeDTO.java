package com.insurance.life.product.common.dto;

import java.io.Serializable;

public class PaymentTypeDTO implements Serializable {

    private String paymentType;
    private String description;

    public PaymentTypeDTO(String paymentType, String description) {
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
