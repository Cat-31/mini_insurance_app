package com.insurance.life.product.service.strategy.premium;

import com.insurance.life.product.entity.Rate;
import com.insurance.life.product.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Component
public class PremiumCalculateWithTable implements PremiumCalculate {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public BigDecimal calculate(PremiumCalculateRequest request) {
        Rate rate = rateRepository.findByProductIdAndAgeAndGender(
                request.getProductId(), request.getAge(), request.getGender());
        return request.getAmount().multiply(rate.getRate()).setScale(0, RoundingMode.CEILING);
    }
}
