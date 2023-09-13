package com.insurance.life.sales.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SalesService {

    public void test() {
        System.out.println("SalesServiceSalesServiceSalesService");
    }

    public BigDecimal calculatePremium(String productCode, BigDecimal amount) {
        return new BigDecimal((int)( Math.random() * 1000));
    }
}
