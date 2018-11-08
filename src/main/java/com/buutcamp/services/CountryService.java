package com.buutcamp.services;

import com.buutcamp.dao.CountryDAO;
import com.buutcamp.entity.*;
import com.buutcamp.main.SortCountries;
import com.buutcamp.main.TestCountry;
import org.hibernate.resource.beans.container.internal.JpaCompliantLifecycleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Autowired
    private TestCountry testCountry;
    @Autowired
    private SortCountries sortCountries;

    public List<VisitedCountry> getCountries() {
        return countryDAO.getCountries();
    }
    public int getLast(List<VisitedCountry> list){
        int newist=0;
        for(VisitedCountry country:list){
            if (country.getId()>newist){
                newist = country.getId();
            }
        }
        return newist;
    }
    public void setContinent(VisitedCountry visitedCountry){

        int i;
        List<AsianCountry>asianCountries=new ArrayList<AsianCountry>();
        List<AfricanCountry>africanCountries =new ArrayList<AfricanCountry>();
        List<EuropanCountry>europanCountries = new ArrayList<EuropanCountry>();
        List<OceanianCountry>oceanianCountries =new ArrayList<OceanianCountry>();
        List<NorthAmericanCountry>northAmericanCountries=new ArrayList<NorthAmericanCountry>();
        List<SouthAmericanCountry>southAmericanCountries=new ArrayList<SouthAmericanCountry>();

        asianCountries=countryDAO.getAsianCountries();
        if (asianCountries != null) {
            for (i = 0; i < asianCountries.size(); i++) {
                if (asianCountries.get(i).getName().toLowerCase().equals(visitedCountry.getName().toLowerCase())) {
                    visitedCountry.setContinent("asia");
                    return;
                }
            }
        }
        africanCountries=countryDAO.getAfricanCountries();
        for (i=0;i<africanCountries.size();i++){
            if (africanCountries.get(i).getName().toLowerCase().equals(visitedCountry.getName().toLowerCase())){
                visitedCountry.setContinent("africa");
                return;
            }
        }
        europanCountries=countryDAO.getEuropanCountries();
        for (i=0;i<europanCountries.size();i++){
            if (europanCountries.get(i).getName().toLowerCase().equals(visitedCountry.getName().toLowerCase())){
                visitedCountry.setContinent("europa");
                return;
            }
        }
        oceanianCountries=countryDAO.getOceanianCountries();
        for (i=0;i<oceanianCountries.size();i++){
            if (oceanianCountries.get(i).getName().toLowerCase().equals(visitedCountry.getName().toLowerCase())){
                visitedCountry.setContinent("oceania");
                return;
            }
        }
        northAmericanCountries=countryDAO.getNorthAmericanCountries();
        for (i=0;i<northAmericanCountries.size();i++){
            if (northAmericanCountries.get(i).getName().toLowerCase().equals(visitedCountry.getName().toLowerCase())){
                visitedCountry.setContinent("north_america");
                return;
            }
        }
        southAmericanCountries=countryDAO.getSouthAmericanCountries();
        for (i=0;i<southAmericanCountries.size();i++){
            if (southAmericanCountries.get(i).getName().toLowerCase().equals(visitedCountry.getName().toLowerCase())){
                visitedCountry.setContinent("south_america");
                return;
            }
        }
    }
    public void saveNewCountry(VisitedCountry visitedCountry){
        Year vuosi = new Year(visitedCountry.getYear());
        vuosi.setCountry(visitedCountry.getName());
        visitedCountry.addVuosi(vuosi);
        countryDAO.saveAll(visitedCountry,vuosi);
    }

    public void saveHandler(VisitedCountry visitedCountry) {
        List<VisitedCountry> countries = countryDAO.getCountries();
        int id =testCountry.existsInSQL(visitedCountry,countries);
        System.out.println(id);
        if (id==-1) {
            saveNewCountry(visitedCountry);
        } else {
            if (id>-1) {
                for (VisitedCountry country:countries) {
                    if (country.getId()==id){
                        Year vuosi = new Year(visitedCountry.getYear());
                        vuosi.setCountry(country.getName());
                        country.addVuosi(vuosi);
                        countryDAO.saveAll(country,vuosi);
                        //country.setYear(visitedCountry.getYear());
                        //countryDAO.saveCountry(country);
                    }

                }

            }
        }
    }
}
