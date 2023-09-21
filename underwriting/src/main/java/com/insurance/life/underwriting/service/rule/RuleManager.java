package com.insurance.life.underwriting.service.rule;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleManager {

    private List<Rule> ruleList;

    public RuleManager(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }

    public List<Rule> getRuleList() {
        return ruleList;
    }
}
