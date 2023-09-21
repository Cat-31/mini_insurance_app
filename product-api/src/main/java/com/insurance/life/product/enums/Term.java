package com.insurance.life.product.enums;

public enum Term {
    YEAR_1("1","1年"),
    YEAR_3("3","3年"),
    YEAR_5("5","5年"),
    YEAR_10("10","10年"),
    YEAR_15("15","15年"),
    YEAR_20("20","20年"),
    YEAR_99("99","終身");

    private String term;
    private String description;

    Term(String term, String description) {
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
