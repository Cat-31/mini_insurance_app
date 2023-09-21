package com.insurance.life.product.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private String productId;
    private String productName;

    public ProductDTO(String productId, String productName) {
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
