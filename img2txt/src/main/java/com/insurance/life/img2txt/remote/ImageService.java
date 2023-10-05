package com.insurance.life.img2txt.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "images", url = "http://127.0.0.1:5000/")
public interface ImageService {
    @GetMapping("/img/get/{id}")
    ImageDTO getImg(@PathVariable("id") String id);

    @GetMapping("/img/info/{barcode}")
    List<ImageInfoDTO> getInfo(@PathVariable("barcode") String barcode);
}
