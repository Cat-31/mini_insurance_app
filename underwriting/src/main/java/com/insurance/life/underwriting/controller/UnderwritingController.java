package com.insurance.life.underwriting.controller;

import com.insurance.life.underwriting.api.UnderwritingApi;
import com.insurance.life.underwriting.dto.Application;
import com.insurance.life.underwriting.dto.UnderWritingResult;
import com.insurance.life.underwriting.remote.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnderwritingController implements UnderwritingApi {

    @Autowired
    private ProductService productService;

    public String ok() {
        return "Underwriting is ok   ";
    }

    public String callProduct() {
        return "underwriting call " + productService.ok();
    }

    public ResponseEntity<UnderWritingResult> application(@RequestBody Application application) {
        UnderWritingResult result = new UnderWritingResult();
        result.setApplicationId("A00001");
        result.setPass(true);
        System.out.println(application);
        return ResponseEntity.ok(result);
    }
}
