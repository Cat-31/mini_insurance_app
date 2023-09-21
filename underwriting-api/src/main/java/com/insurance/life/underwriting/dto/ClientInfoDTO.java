package com.insurance.life.underwriting.dto;

import java.io.Serializable;
import java.util.StringJoiner;

public class ClientInfoDTO implements Serializable {
    private String name;
    private String gender;
    private int age;

    public ClientInfoDTO(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ClientInfoDTO.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("gender='" + gender + "'")
                .add("age=" + age)
                .toString();
    }
}
