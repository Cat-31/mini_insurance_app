package com.insurance.life.product.service;

import com.insurance.life.product.dto.*;
import com.insurance.life.product.entity.Product;
import com.insurance.life.product.repository.ProductRepository;
import com.insurance.life.product.service.strategy.premium.PremiumCalculateRequest;
import com.insurance.life.product.service.strategy.premium.PremiumCalculateStrategyFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private PremiumCalculateStrategyFactory premiumCalculateStrategyFactory;

    public ProductService(ProductRepository productRepository,
                          PremiumCalculateStrategyFactory premiumCalculateStrategyFactory) {
        this.productRepository = productRepository;
        this.premiumCalculateStrategyFactory = premiumCalculateStrategyFactory;
    }

    public List<ProductDTO> queryAllProduct() {
        List<ProductDTO> products = new ArrayList<>();
        productRepository.findAll().forEach(item -> {
            products.add(new ProductDTO(item.getId(), item.getName()));
        });

        return products;
    }

    public List<PaymentTypeDTO> querySupportedPaymentType(String productId) {
        return productRepository.findById(productId).get()
                .getConfig().getSupportedPaymentType().stream().map(
                        item -> new PaymentTypeDTO(item.getType(), item.getDescription())
                ).collect(Collectors.toList());
    }

    public List<TermDTO> querySupportedTerm(String productId) {
        return productRepository.findById(productId).get()
                .getConfig().getSupportedTerm().stream().map(
                        item -> new TermDTO(item.getTerm(), item.getDescription())
                ).collect(Collectors.toList());
    }

    public BigDecimal premiumCalculate(String productId, PremiumCalculateParam param) {
        Product product = productRepository.findById(productId).get();
        String strategy = product.getConfig().getPremiumCalculateStrategyName();
        PremiumCalculateRequest request = new PremiumCalculateRequest();
        BeanUtils.copyProperties(param, request);
        request.setProductId(productId);
        return premiumCalculateStrategyFactory.getStrategy(strategy).calculate(request);
    }

    public ConfigDTO getConfig(String productId) {
        ConfigDTO dto = new ConfigDTO();
        BeanUtils.copyProperties(productRepository.findById(productId).get().getConfig(), dto);
        return dto;
    }
}
