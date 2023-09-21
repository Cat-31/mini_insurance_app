package com.insurance.life.underwriting.api;

import com.insurance.life.underwriting.dto.ApplicationDTO;
import com.insurance.life.underwriting.dto.UnderWritingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UnderwritingApi {
    @PostMapping("/application")
    ResponseEntity<UnderWritingResult> application(@RequestBody ApplicationDTO application);
}


