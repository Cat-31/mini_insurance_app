package com.insurance.life.underwriting.controller;

import com.insurance.life.underwriting.remote.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnderwritingController {

    @Autowired
    private ProductService productService;

    @GetMapping("/ok")
    public String ok() {
        return "Underwriting is ok   ";
    }

    @GetMapping("/call/product/ok")
    public String callProduct() {
        return "underwriting call " + productService.ok();
    }
}
