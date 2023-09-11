package com.insurance.life.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/ok")
    public String ok() {
        return "Product is ok   ";
    }
}
