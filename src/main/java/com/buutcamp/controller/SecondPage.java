package com.buutcamp.controller;

import com.buutcamp.dao.CountryDAO;
import com.buutcamp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SecondPage {
    @Autowired
    private CountryDAO countryDAO;

    @GetMapping("/second-page")
    public String secondPageGET(Model model){

        List<AfricanCountry> africanCountries = countryDAO.getAfricanCountries();
        List<AsianCountry> asianCountries = countryDAO.getAsianCountries();
        List<EuropanCountry> europanCountries=countryDAO.getEuropanCountries();
        List<NorthAmericanCountry>northAmericanCountries=countryDAO.getNorthAmericanCountries();
        List<SouthAmericanCountry>southAmericanCountries=countryDAO.getSouthAmericanCountries();
        List<OceanianCountry>oceanianCountries=countryDAO.getOceanianCountries();
        model.addAttribute("africa",africanCountries);
        model.addAttribute("asia",asianCountries);
        model.addAttribute("europa",europanCountries);
        model.addAttribute("north_america",northAmericanCountries);
        model.addAttribute("south_america",southAmericanCountries);
        model.addAttribute("oceania",oceanianCountries);


        return "second-page";

    }
}
