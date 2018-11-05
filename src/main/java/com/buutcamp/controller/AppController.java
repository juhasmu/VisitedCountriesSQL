package com.buutcamp.controller;

import com.buutcamp.config.AppConfig;
import com.buutcamp.dao.CountryDAO;
import com.buutcamp.entity.VisitedCountry;
import com.buutcamp.entity.Year;
import com.buutcamp.main.SortCountries;
import com.buutcamp.main.TestCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    //DAO reference
    @Autowired
    private CountryDAO countryDAO;
    @Autowired
    private TestCountry testCountry;
    @Autowired
    private SortCountries sortCountries;


    @GetMapping("/")
    public String frontPageGET(Model model){

        //AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        //CountryDAO countryDAO = appCtx.getBean("countryDAO",CountryDAO.class);
        List<VisitedCountry> countries = countryDAO.getCountries();
        //List<String> simpleList = new ArrayList<String>();
        sortCountries.sortList(countries);
        model.addAttribute("countries", countries);

        model.addAttribute("visitedCountry",new VisitedCountry());

        return "front-page";

    }
    @PostMapping("saveCountry")
    public String saveCountry(@ModelAttribute("visitedCountry") VisitedCountry visitedCountry, Model model){
        //AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        //CountryDAO countryDAO = appCtx.getBean("countryDAO",CountryDAO.class);
        testCountry.setContinent(visitedCountry);
        if(visitedCountry.getContinent()!=null) {
            Year vuosi = new Year(visitedCountry.getYear());
            visitedCountry.addVuosi(vuosi);
            vuosi.addCountry(visitedCountry);
            countryDAO.saveAll(visitedCountry, vuosi);
        }

        return "redirect:/";
    }
}
