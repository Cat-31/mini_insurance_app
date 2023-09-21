package com.insurance.life.underwriting.remote;

import com.insurance.life.product.api.ProductApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product", path = "/")
public interface ProductService extends ProductApi {
}
