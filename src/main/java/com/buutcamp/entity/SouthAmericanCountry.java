package com.buutcamp.entity;

import javax.persistence.*;

@Entity
@Table(name = "southamericancountry")
public class SouthAmericanCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public SouthAmericanCountry() {
    }

    public SouthAmericanCountry(String name) {
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
