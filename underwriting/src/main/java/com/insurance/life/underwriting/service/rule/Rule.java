package com.insurance.life.underwriting.service.rule;


import com.insurance.life.underwriting.dto.UnPassedReason;
import com.insurance.life.underwriting.entity.Application;

public abstract class Rule {
    abstract String getMessage(Object ... params);
    abstract boolean needCheck(Application application);
    abstract UnPassedReason doCheck(Application application);

    public final UnPassedReason check(Application application) {
        if (needCheck(application)) {
            return doCheck(application);
        } else {
            return null;
        }
    }
}
