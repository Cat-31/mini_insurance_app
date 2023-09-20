package com.insurance.life.product.common.dto;

import java.io.Serializable;

public class TermDTO implements Serializable {

    private String term;
    private String description;

    public TermDTO(String term, String description) {
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
