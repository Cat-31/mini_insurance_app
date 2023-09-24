package com.insurance.life.sales.service.command;

import com.insurance.life.sales.common.command.Command;

public class QuerySupportedTermCommand implements Command {
    private String productId;

    public QuerySupportedTermCommand(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
