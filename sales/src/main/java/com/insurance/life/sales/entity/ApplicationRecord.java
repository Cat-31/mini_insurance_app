package com.insurance.life.sales.entity;

import com.insurance.life.underwriting.UnderWritingStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.StringJoiner;

@Entity
public class ApplicationRecord {
    @Id
    @GeneratedValue
    private Long id;
    private String applicationId;

    @Enumerated(EnumType.STRING)
    private UnderWritingStatus status;

    private Date applicationDate;

    public ApplicationRecord() {
    }

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

    @Override
    public String toString() {
        return new StringJoiner(", ", ApplicationRecord.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("applicationId='" + applicationId + "'")
                .add("status=" + status)
                .add("applicationDate=" + applicationDate)
                .toString();
    }
}
