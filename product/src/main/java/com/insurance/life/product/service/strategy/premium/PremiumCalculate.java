package com.insurance.life.product.service.strategy.premium;

import java.math.BigDecimal;

public interface PremiumCalculate {
    BigDecimal calculate(PremiumCalculateRequest request);
    default String getName() {
        return this.getClass().getSimpleName();
    }
}
