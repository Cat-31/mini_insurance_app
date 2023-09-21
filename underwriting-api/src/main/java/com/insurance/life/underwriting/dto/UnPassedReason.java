package com.insurance.life.underwriting.dto;

import java.util.StringJoiner;

public class UnPassedReason {
    private String code;
    private String description;

    public UnPassedReason(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UnPassedReason.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("description='" + description + "'")
                .toString();
    }
}
