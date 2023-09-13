package com.insurance.life.sales.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product", url = "${gateway.domain}/product")
public interface ProductService {
    @GetMapping("/ok")
    String ok();
}
