package com.insurance.life.product.controller;

import com.insurance.life.product.common.dto.PaymentTypeDTO;
import com.insurance.life.product.common.dto.PremiumCalculateParam;
import com.insurance.life.product.common.dto.TermDTO;
import com.insurance.life.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/ok")
    public String ok() {
        return "Product is ok   ";
    }


    @GetMapping("/queryAllProduct")
    public ResponseEntity queryAllProduct() {
        return ResponseEntity.ok(productService.queryAllProduct());
    }

    @GetMapping("/{productId}/querySupportedTerm")
    ResponseEntity<List<TermDTO>> querySupportedTerm(@PathVariable String productId) {
        return ResponseEntity.ok(productService.querySupportedTerm(productId));
    }

    @GetMapping("/{productId}/querySupportedPaymentType")
    ResponseEntity<List<PaymentTypeDTO>> querySupportedPaymentType(@PathVariable String productId) {
        return ResponseEntity.ok(productService.querySupportedPaymentType(productId));
    }

    @PostMapping("/{productId}/premiumCalculate")
    ResponseEntity<BigDecimal> premiumCalculate(@PathVariable String productId,
                                                @RequestBody PremiumCalculateParam param) {
        return ResponseEntity.ok(productService.premiumCalculate(productId, param));
    }
}
