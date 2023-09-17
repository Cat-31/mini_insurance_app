package com.insurance.life.product;

import com.insurance.life.product.common.PaymentType;
import com.insurance.life.product.common.Term;
import com.insurance.life.product.entity.Config;
import com.insurance.life.product.entity.Product;
import com.insurance.life.product.entity.Rate;
import com.insurance.life.product.repository.ProductRepository;
import com.insurance.life.product.repository.RateRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private RateRepository rateRepository;


    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @PostConstruct
    public void init() {
        initProduct();
        initRate();
    }

    private void initRate() {
        rateRepository.deleteAll();
        Rate rate;

        for (int i = 10; i < 80; i++) {
            rate = new Rate("P001", i, "F",
                    new BigDecimal(1   + i/1000.0).divide(
                            new BigDecimal(100), RoundingMode.HALF_DOWN).setScale(6, RoundingMode.HALF_DOWN));

            rateRepository.save(rate);

            rate = new Rate("P001", i, "M",
                    new BigDecimal(1.1 + i/1000.0).divide(
                            new BigDecimal(100), RoundingMode.HALF_DOWN).setScale(6, RoundingMode.HALF_DOWN));
            rateRepository.save(rate);
        }
    }

    private void initProduct() {
        repository.deleteAll();
        Config config = new Config(18,
                60,
                new BigDecimal(300000),
                "PremiumCalculateWithTable",
                Arrays.asList(Term.YEAR_1, Term.YEAR_3, Term.YEAR_10, Term.YEAR_20),
                Arrays.asList(PaymentType.TYPE_MONTH));

        Product product = new Product("P001", "安心医療", config);
        repository.save(product);

        config = new Config(18,
                60,
                new BigDecimal(1000000),
                "PremiumCalculateWithFixedRate",
                Arrays.asList(Term.YEAR_10, Term.YEAR_15, Term.YEAR_20),
                Arrays.asList(PaymentType.TYPE_YEAR));

        product = new Product("P002", "安心年金", config);
        repository.save(product);
    }
}
