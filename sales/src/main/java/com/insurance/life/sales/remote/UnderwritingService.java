package com.insurance.life.sales.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "underwriting", url = "${gateway.domain}/underwriting")
// @FeignClient(name = "underwriting", path = "/")
public interface UnderwritingService {
    @GetMapping("/ok")
    String ok();
}
