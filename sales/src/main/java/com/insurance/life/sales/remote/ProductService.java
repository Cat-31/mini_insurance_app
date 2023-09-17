package com.insurance.life.sales.remote;

import com.insurance.life.sales.remote.dto.PaymentTypeOption;
import com.insurance.life.sales.remote.dto.PremiumCalculateParam;
import com.insurance.life.sales.remote.dto.ProductOption;
import com.insurance.life.sales.remote.dto.TermOption;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "product", url = "${gateway.domain}/product")
public interface ProductService {
    @GetMapping("/ok")
    String ok();

    @GetMapping("/queryAllProduct")
    ResponseEntity<List<ProductOption>> queryAllProduct();

    @GetMapping("/{productId}/querySupportedTerm")
    ResponseEntity<List<TermOption>> querySupportedTerm(@PathVariable("productId") String productId);

    @GetMapping("/{productId}/querySupportedPaymentType")
    ResponseEntity<List<PaymentTypeOption>> querySupportedPaymentType(@PathVariable String productId);

    @PostMapping("/{productId}/premiumCalculate")
    ResponseEntity<BigDecimal> premiumCalculate(@PathVariable String productId,
                                                @RequestBody PremiumCalculateParam param);
}
