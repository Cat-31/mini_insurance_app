package com.insurance.life.sales.remote;

import com.insurance.life.product.api.ProductApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product", url = "${gateway.domain}/product")
public interface ProductService extends ProductApi {

}
