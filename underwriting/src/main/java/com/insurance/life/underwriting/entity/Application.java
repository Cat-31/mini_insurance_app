package com.insurance.life.underwriting.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
public class Application {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Applicant applicant;
    @OneToOne(cascade = CascadeType.ALL)
    private Insured insured;

    private String paymentType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Plan> planList = new ArrayList<>();

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Application.class.getSimpleName() + "[", "]")
                .add("applicant=" + applicant)
                .add("insured=" + insured)
                .add("paymentType='" + paymentType + "'")
                .add("planList=" + planList)
                .toString();
    }
}
