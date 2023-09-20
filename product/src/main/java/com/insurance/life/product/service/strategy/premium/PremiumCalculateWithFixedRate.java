package com.insurance.life.product.service.strategy.premium;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Component
public class PremiumCalculateWithFixedRate implements PremiumCalculate {
    @Override
    public BigDecimal calculate(PremiumCalculateRequest request) {
        return request.getAmount()
                      .divide(new BigDecimal(request.getTerm()), RoundingMode.HALF_DOWN)
                      .multiply(new BigDecimal(1.10))
                      .setScale(0, RoundingMode.CEILING);
    }
}
