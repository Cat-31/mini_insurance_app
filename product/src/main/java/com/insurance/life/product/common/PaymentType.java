package com.insurance.life.product.common;

public enum PaymentType {
    TYPE_1("0", "一括"),
    TYPE_MONTH("1", "月払い"),
    TYPE_YEAR("2", "年払い");

    private String value;
    private String description;

    PaymentType(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
