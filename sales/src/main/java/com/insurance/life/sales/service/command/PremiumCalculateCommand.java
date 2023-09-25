package com.insurance.life.sales.service.command;

import com.insurance.life.product.dto.PremiumCalculateParam;
import com.insurance.life.sales.common.command.Command;

public class PremiumCalculateCommand implements Command {
    private String productId;
    private PremiumCalculateParam param;

    public PremiumCalculateCommand(String productId, PremiumCalculateParam param) {
        this.productId = productId;
        this.param = param;
    }

    public String getProductId() {
        return productId;
    }

    public PremiumCalculateParam getParam() {
        return param;
    }
}
