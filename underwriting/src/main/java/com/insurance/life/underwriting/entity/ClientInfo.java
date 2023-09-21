package com.insurance.life.underwriting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

import java.io.Serializable;
import java.util.StringJoiner;

@Entity
@Inheritance
public class ClientInfo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String gender;
    private int age;

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
        return new StringJoiner(", ", ClientInfo.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("gender='" + gender + "'")
                .add("age=" + age)
                .toString();
    }
}
