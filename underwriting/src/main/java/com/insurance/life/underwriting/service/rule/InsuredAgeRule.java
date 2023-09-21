package com.insurance.life.underwriting.service.rule;

import com.insurance.life.product.dto.ConfigDTO;
import com.insurance.life.underwriting.dto.UnPassedReason;
import com.insurance.life.underwriting.entity.Application;
import com.insurance.life.underwriting.remote.ProductService;
import org.springframework.stereotype.Component;


@Component
public class InsuredAgeRule extends Rule {
    private ProductService productService;

    public InsuredAgeRule(ProductService productService) {
        this.productService = productService;
    }

    @Override
    String getMessage(Object... params) {
        return "被保険者の年齢は%d歳以上%d歳未満である必要がある。".formatted(params);
    }

    @Override
    public boolean needCheck(Application application) {
        return true;
    }

    @Override
    public UnPassedReason doCheck(Application application) {
        ConfigDTO config = productService.getConfig(
                application.getPlanList().get(0).getProductId()).getBody();

        UnPassedReason unPassedReason = null;
        if (application.getInsured().getAge() < config.getMinAge()
                || application.getInsured().getAge() > config.getMaxAge()) {

            unPassedReason = new UnPassedReason("R0002",
                    getMessage(config.getMinAge(),config.getMaxAge()));
        }
        return unPassedReason;
    }
}
