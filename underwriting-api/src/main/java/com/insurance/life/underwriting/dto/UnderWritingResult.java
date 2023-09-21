package com.insurance.life.underwriting.dto;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

public class UnderWritingResult implements Serializable {
    private String applicationId;
    private List<UnPassedReason> unPassedReasonList;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public boolean isPass() {
        return CollectionUtils.isEmpty(unPassedReasonList);
    }


    public List<UnPassedReason> getUnPassedReasonList() {
        return unPassedReasonList;
    }

    public void setUnPassedReasonList(List<UnPassedReason> unPassedReasonList) {
        this.unPassedReasonList = unPassedReasonList;
    }
}
