package com.insurance.life.product.enums;

public enum PaymentType {
    TYPE_ALL("0", "一括"),
    TYPE_MONTH("1", "月払い"),
    TYPE_YEAR("2", "年払い");

    private String type;
    private String description;

    PaymentType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
