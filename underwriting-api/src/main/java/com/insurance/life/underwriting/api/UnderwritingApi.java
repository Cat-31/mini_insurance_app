package com.insurance.life.underwriting.api;

import com.insurance.life.underwriting.dto.Application;
import com.insurance.life.underwriting.dto.UnderWritingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UnderwritingApi {

    @GetMapping("/ok")
    String ok();

    @GetMapping("/call/product/ok")
    String callProduct();

    @PostMapping("/application")
    ResponseEntity<UnderWritingResult> application(@RequestBody Application application);
}


