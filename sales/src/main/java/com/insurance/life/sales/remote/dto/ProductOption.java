package com.insurance.life.sales.remote.dto;

import java.io.Serializable;

public class ProductOption implements Serializable {

    private String productId;
    public String productName;

    public ProductOption(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}
