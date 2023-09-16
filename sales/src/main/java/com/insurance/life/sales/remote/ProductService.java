package com.insurance.life.sales.remote;

import com.insurance.life.sales.remote.dto.ProductOption;
import com.insurance.life.sales.remote.dto.TermOption;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product", url = "${gateway.domain}/product")
public interface ProductService {
    @GetMapping("/ok")
    String ok();

    @GetMapping("/queryAllProduct")
    ResponseEntity<List<ProductOption>> queryAllProduct();

    @GetMapping("/{productCode}/querySupportedTerm")
    ResponseEntity<List<TermOption>> querySupportedTerm(@PathVariable("productCode") String productCode);
}
