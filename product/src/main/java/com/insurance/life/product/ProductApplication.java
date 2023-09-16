package com.insurance.life.product;

import com.google.gson.Gson;
import com.insurance.life.product.entity.Config;
import com.insurance.life.product.entity.PaymentType;
import com.insurance.life.product.entity.Product;
import com.insurance.life.product.entity.Term;
import com.insurance.life.product.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {

	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@PostConstruct
	public void init() {
		repository.deleteAll();
		Config config = new Config(18,
				60,
				new BigDecimal(300000),
				Arrays.asList(Term.YEAR_1, Term.YEAR_3, Term.YEAR_10, Term.YEAR_20),
				Arrays.asList(PaymentType.TYPE_MONTH, PaymentType.TYPE_YEAR));

		Product product = new Product("P001", "安心医療", config);
		repository.save(product);

		config = new Config(18,
				60,
				new BigDecimal(1000000),
				Arrays.asList(Term.YEAR_10, Term.YEAR_15, Term.YEAR_20),
				Arrays.asList(PaymentType.TYPE_MONTH, PaymentType.TYPE_YEAR));

		product = new Product("P002", "安心年金", config);
		repository.save(product);

		Gson gson = new Gson();
		System.out.println(gson.toJson(product));
	}
}
