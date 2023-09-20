package com.insurance.life.underwriting.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product", path = "/")
public interface ProductService {
    @GetMapping("/ok")
    String ok();
}
