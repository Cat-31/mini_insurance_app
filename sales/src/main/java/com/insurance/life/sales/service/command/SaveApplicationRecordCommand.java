package com.insurance.life.sales.service.command;

import com.insurance.life.sales.common.command.Command;
import com.insurance.life.underwriting.UnderWritingStatus;

import java.util.Date;

public class SaveApplicationRecordCommand implements Command {
    private String applicationId;
    private UnderWritingStatus status;
    private Date applicationDate;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public UnderWritingStatus getStatus() {
        return status;
    }

    public void setStatus(UnderWritingStatus status) {
        this.status = status;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }
}
