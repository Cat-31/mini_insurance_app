package com.insurance.life.underwriting.controller;

import com.insurance.life.underwriting.api.UnderwritingApi;
import com.insurance.life.underwriting.dto.ApplicationDTO;
import com.insurance.life.underwriting.dto.UnderWritingResult;
import com.insurance.life.underwriting.service.UnderwritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnderwritingController implements UnderwritingApi {

    @Autowired
    private UnderwritingService underwritingService;

    @Override
    public ResponseEntity<UnderWritingResult> application(@RequestBody ApplicationDTO application) {
        return ResponseEntity.ok(underwritingService.createAndCheck(application));
    }
}
