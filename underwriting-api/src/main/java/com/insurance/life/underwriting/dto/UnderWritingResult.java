package com.insurance.life.underwriting.dto;

import java.io.Serializable;

public class UnderWritingResult implements Serializable {
    private String applicationId;
    private boolean isPass;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }
}
