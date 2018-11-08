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
    @Column(name = "continent")
    private String continent;

    //@ElementCollection
    //@CollectionTable(name="Years", joinColumns=@JoinColumn(name="visitedcountry_id"))
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "years")
    private List<Year> years;

    public void addVuosi(Year vuosi){

        if (years==null){
            years=new ArrayList<>();
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

    public VisitedCountry(String name, Year year) {
        this.name = name;
        this.addVuosi(year);
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "VisitedCountry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", continent='" + continent + '\'' +
                ", years=" + years +
                '}';
    }
}
