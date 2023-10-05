package com.insurance.life.img2txt.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ocr", url = "http://127.0.0.1:5000/")
public interface OcrService {
    @GetMapping("/ocr/{id}")
    List<String> ocr(@PathVariable("id") String id);

}
