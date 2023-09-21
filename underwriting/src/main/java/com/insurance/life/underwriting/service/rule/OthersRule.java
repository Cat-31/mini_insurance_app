package com.insurance.life.underwriting.service.rule;

import com.insurance.life.underwriting.dto.UnPassedReason;
import com.insurance.life.underwriting.entity.Application;
import org.springframework.stereotype.Component;


@Component
public class OthersRule extends Rule {
    @Override
    String getMessage(Object... params) {
        return null;
    }

    @Override
    public boolean needCheck(Application application) {
        return false;
    }

    @Override
    public UnPassedReason doCheck(Application application) {
        return null;
    }
}
