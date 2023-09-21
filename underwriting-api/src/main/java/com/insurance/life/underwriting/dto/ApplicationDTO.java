package com.insurance.life.underwriting.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ApplicationDTO {
    private ApplicantDTO applicant;
    private InsuredDTO insured;
    private String paymentType;

    private List<PlanDTO> planList = new ArrayList<>();

    public ApplicantDTO getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantDTO applicant) {
        this.applicant = applicant;
    }

    public InsuredDTO getInsured() {
        return insured;
    }

    public void setInsured(InsuredDTO insured) {
        this.insured = insured;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<PlanDTO> getPlanList() {
        return planList;
    }

    public void setPlanList(List<PlanDTO> planList) {
        this.planList = planList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApplicationDTO.class.getSimpleName() + "[", "]")
                .add("applicant=" + applicant)
                .add("insured=" + insured)
                .add("paymentType='" + paymentType + "'")
                .add("planList=" + planList)
                .toString();
    }
}
