package com.insurance.life.sales.front.vo;

import java.util.StringJoiner;

public class ApplicationRecordVO {
    private String applicationId;
    private String status;
    private String applicationDate;

    public ApplicationRecordVO(String applicationId, String status, String applicationDate) {
        this.applicationId = applicationId;
        this.status = status;
        this.applicationDate = applicationDate;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getStatus() {
        return status;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApplicationRecordVO.class.getSimpleName() + "[", "]")
                .add("applicationId='" + applicationId + "'")
                .add("status='" + status + "'")
                .add("applicationDate='" + applicationDate + "'")
                .toString();
    }
}
