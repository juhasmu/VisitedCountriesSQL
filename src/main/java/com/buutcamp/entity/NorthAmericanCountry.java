package com.buutcamp.entity;

import javax.persistence.*;

@Entity
@Table(name = "northamericancountry")
public class NorthAmericanCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public NorthAmericanCountry() {
    }

    public NorthAmericanCountry(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
