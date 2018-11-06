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
    public boolean existsInSQL(VisitedCountry visitedCountry){
        int i,j;
        List<VisitedCountry> countries = countryDAO.getCountries();
        for (VisitedCountry country: countries) {
            if (country.getName().equals(visitedCountry.getName())){
                if (country.getYear() == visitedCountry.getYear()) {
                    return true;
                } else {
                    //country.addVuosi(visitedCountry.getYear());
                    country.setYear(visitedCountry.getYear());
                    countryDAO.saveCountry(country);
                    return true;
                }
            }
        }
        return false;
        /*
        for(i=0;i<countries.size();i++){
            if (countries.get(i).getName().equals(visitedCountry)){
                List<Year> years = countries.get(i).getYears();
                for (j=0;j<years.size();i++){
                    if(visitedCountry.getYear()==years.get(j).getYear()){
                        return true;
                    }
                }
                Year vuosi = new Year(visitedCountry.getYear());
                countries.get(i).addVuosi(vuosi);
                vuosi.addCountry(countries.get(i));
                System.out.println("MyCountry: "+countries.get(i).getName()+" "+vuosi.getYear());
                countryDAO.saveAll(countries.get(i),vuosi);
                return true;
            }
        }
        return false;*/
    }
}
