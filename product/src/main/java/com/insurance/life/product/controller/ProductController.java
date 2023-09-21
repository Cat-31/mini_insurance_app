package com.insurance.life.product.controller;

import com.insurance.life.product.api.ProductApi;
import com.insurance.life.product.dto.*;
import com.insurance.life.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController implements ProductApi {
    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<List<ProductDTO>> queryAllProduct() {
        return ResponseEntity.ok(productService.queryAllProduct());
    }

    @Override
    public ResponseEntity<List<TermDTO>> querySupportedTerm(@PathVariable String productId) {
        return ResponseEntity.ok(productService.querySupportedTerm(productId));
    }

    @Override
    public ResponseEntity<List<PaymentTypeDTO>> querySupportedPaymentType(@PathVariable String productId) {
        return ResponseEntity.ok(productService.querySupportedPaymentType(productId));
    }

    @Override
    public ResponseEntity<BigDecimal> premiumCalculate(@PathVariable String productId,
                                                @RequestBody PremiumCalculateParam param) {
        return ResponseEntity.ok(productService.premiumCalculate(productId, param));
    }

    @Override
    public ResponseEntity<ConfigDTO> getConfig(String productId) {
        return ResponseEntity.ok(productService.getConfig(productId));
    }
}
