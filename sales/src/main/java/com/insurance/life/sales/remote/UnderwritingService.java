package com.insurance.life.sales.remote;

import com.insurance.life.underwriting.api.UnderwritingApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "underwriting", url = "${gateway.domain}/underwriting")
public interface UnderwritingService extends UnderwritingApi {

}
