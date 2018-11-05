package com.buutcamp.entity;

import javax.persistence.*;

@Entity
@Table(name = "asiancountry")
public class AsianCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public AsianCountry(String name) {
        this.name = name;
    }

    public AsianCountry() {
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
