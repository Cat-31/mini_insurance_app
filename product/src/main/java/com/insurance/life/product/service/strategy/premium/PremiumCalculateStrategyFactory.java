package com.insurance.life.product.service.strategy.premium;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PremiumCalculateStrategyFactory {
    private Map<String, PremiumCalculate> strategyMap;

    public PremiumCalculateStrategyFactory(List<PremiumCalculate> strategies) {
        strategyMap = strategies.stream()
                .collect(Collectors.toMap(PremiumCalculate::getName, x -> x));
    }

    public PremiumCalculate getStrategy(String name) {
        return strategyMap.get(name);
    }
}
