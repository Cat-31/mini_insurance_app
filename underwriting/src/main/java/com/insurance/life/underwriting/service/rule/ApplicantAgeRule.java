package com.insurance.life.underwriting.service.rule;

import com.insurance.life.underwriting.dto.UnPassedReason;
import com.insurance.life.underwriting.entity.Application;
import com.insurance.life.underwriting.remote.ProductService;
import org.springframework.stereotype.Component;


@Component
public class ApplicantAgeRule extends Rule {
    private ProductService productService;

    public ApplicantAgeRule(ProductService productService) {
        this.productService = productService;
    }

    @Override
    String getMessage(Object ... params) {
        return "保険契約者は%d歳以上である必要がある。".formatted(params);
    }

    @Override
    public boolean needCheck(Application application) {
        return true;
    }

    @Override
    public UnPassedReason doCheck(Application application) {
        UnPassedReason unPassedReason = null;
        if (application.getApplicant().getAge() < 18) {
            unPassedReason = new UnPassedReason("R0001","保険契約者は17歳以上である必要がある。");
        }
        return unPassedReason;
    }
}
