package com.insurance.life.product.controller;

import com.insurance.life.product.common.dto.TermDTO;
import com.insurance.life.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/ok")
    public String ok() {
        return "Product is ok   ";
    }


    @GetMapping("/queryAllProduct")
    public ResponseEntity queryAllProduct() {
        return ResponseEntity.ok(productService.queryAllProduct());
    }

    @GetMapping("/{productCode}/querySupportedTerm")
    ResponseEntity<List<TermDTO>> querySupportedTerm(@PathVariable String productCode) {
        return ResponseEntity.ok(productService.querySupportedTerm(productCode));
    }
}
