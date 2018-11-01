package com.buutcamp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visitedcountry")
public class VisitedCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;


    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "visitedcountry_year",joinColumns = @JoinColumn(name = "visitedcountry_id"),inverseJoinColumns = @JoinColumn(name = "year_id"))
    private List<Year> years;

    public void addVuosi(Year vuosi){

        if(this.years == null) {
            this.years = new ArrayList<Year>();
        }

        this.years.add(vuosi);

    }

    public List<Year> getYears() {
        return years;
    }

    public void setYears(List<Year> years) {
        this.years = years;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VisitedCountry(String name, int year) {
        this.name = name;
        this.year = year;
    }
    public VisitedCountry() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
