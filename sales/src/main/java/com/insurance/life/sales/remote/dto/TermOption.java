package com.insurance.life.sales.remote.dto;

import java.io.Serializable;

public class TermOption implements Serializable {

    private String term;
    private String description;

    public TermOption(String term, String description) {
        this.term = term;
        this.description = description;
    }

    public String getTerm() {
        return term;
    }

    public String getDescription() {
        return description;
    }
}
