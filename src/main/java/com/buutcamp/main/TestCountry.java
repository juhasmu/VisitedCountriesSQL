package com.buutcamp.main;

import com.buutcamp.dao.CountryDAO;
import com.buutcamp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestCountry {

    @Autowired
    private CountryDAO countryDAO;

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
                if (asianCountries.get(i).getName().equals(visitedCountry.getName())) {
                    visitedCountry.setContinent("asia");
                    return;
                }
            }
        }
        africanCountries=countryDAO.getAfricanCountries();
        for (i=0;i<africanCountries.size();i++){
            if (africanCountries.get(i).getName().equals(visitedCountry.getName())){
                visitedCountry.setContinent("africa");
                return;
            }
        }
        europanCountries=countryDAO.getEuropanCountries();
        for (i=0;i<europanCountries.size();i++){
            if (europanCountries.get(i).getName().equals(visitedCountry.getName())){
                visitedCountry.setContinent("europa");
                return;
            }
        }
        oceanianCountries=countryDAO.getOceanianCountries();
        for (i=0;i<oceanianCountries.size();i++){
            if (oceanianCountries.get(i).getName().equals(visitedCountry.getName())){
                visitedCountry.setContinent("oceania");
                return;
            }
        }
        northAmericanCountries=countryDAO.getNorthAmericanCountries();
        for (i=0;i<northAmericanCountries.size();i++){
            if (northAmericanCountries.get(i).getName().equals(visitedCountry.getName())){
                visitedCountry.setContinent("north_america");
                return;
            }
        }
        southAmericanCountries=countryDAO.getSouthAmericanCountries();
        for (i=0;i<southAmericanCountries.size();i++){
            if (southAmericanCountries.get(i).getName().equals(visitedCountry.getName())){
                visitedCountry.setContinent("south_america");
                return;
            }
        }
    }
}
