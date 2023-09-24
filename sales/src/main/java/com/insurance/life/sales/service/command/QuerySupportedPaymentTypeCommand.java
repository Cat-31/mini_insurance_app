package com.insurance.life.sales.service.command;

import com.insurance.life.sales.common.command.Command;

public class QuerySupportedPaymentTypeCommand implements Command {
    private String productId;

    public QuerySupportedPaymentTypeCommand(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
