package com.insurance.life.underwriting;

public enum UnderWritingStatus {
    PASS("1","PASS"),
    UNPASS("2","UNPASS");

    private String status;
    private String description;

    UnderWritingStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
