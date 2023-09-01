package com.anurag.jdbc.test;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    // standard constructor, getters and setters

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}


