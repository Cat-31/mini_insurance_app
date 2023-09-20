package com.insurance.life.product.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
    @Id
    private String id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Config config;

    public Product() {
    }

    public Product(String id, String name, Config config) {
        this.id = id;
        this.name = name;
        this.config = config;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public String getId() {
        return id;
    }
}
