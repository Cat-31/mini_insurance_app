package com.insurance.life.sales.common.dto;

import java.util.StringJoiner;

public class ApplicationRecordDTO {
    private String applicationId;
    private String status;
    private String applicationDate;

    public ApplicationRecordDTO(String applicationId, String status, String applicationDate) {
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
        return new StringJoiner(", ", ApplicationRecordDTO.class.getSimpleName() + "[", "]")
                .add("applicationId='" + applicationId + "'")
                .add("status='" + status + "'")
                .add("applicationDate='" + applicationDate + "'")
                .toString();
    }
}
