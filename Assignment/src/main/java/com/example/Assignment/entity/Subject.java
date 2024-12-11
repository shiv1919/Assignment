package com.example.Assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Subject {
    @Id
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
