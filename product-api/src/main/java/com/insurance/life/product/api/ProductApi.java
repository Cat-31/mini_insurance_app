package com.insurance.life.product.api;

import com.insurance.life.product.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

public interface ProductApi {
    @GetMapping("/queryAllProduct")
    ResponseEntity<List<ProductDTO>> queryAllProduct();

    @GetMapping("/{productId}/querySupportedTerm")
    ResponseEntity<List<TermDTO>> querySupportedTerm(@PathVariable String productId) ;

    @GetMapping("/{productId}/querySupportedPaymentType")
    ResponseEntity<List<PaymentTypeDTO>> querySupportedPaymentType(@PathVariable String productId) ;

    @PostMapping("/{productId}/premiumCalculate")
    ResponseEntity<BigDecimal> premiumCalculate(@PathVariable String productId,
                                                @RequestBody PremiumCalculateParam param);

    @GetMapping("/config/{productId}")
    ResponseEntity<ConfigDTO> getConfig(@PathVariable String productId) ;
}
