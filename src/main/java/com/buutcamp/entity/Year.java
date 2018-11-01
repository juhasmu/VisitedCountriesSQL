package com.buutcamp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "year")
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "year")
    private int year;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "visitedcountry_year",joinColumns = @JoinColumn(name = "year_id"),inverseJoinColumns = @JoinColumn(name = "visitedcountry_id"))
    private List<VisitedCountry> countries;

    public Year() {
    }

    public Year(int year) {
        this.year = year;
    }

    public void addCountry(VisitedCountry country){
        if(this.countries == null) {
            this.countries = new ArrayList<VisitedCountry>();
        }
        this.countries.add(country);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<VisitedCountry> getCountries() {
        return countries;
    }

    public void setCountries(List<VisitedCountry> countries) {
        this.countries = countries;
    }
}
