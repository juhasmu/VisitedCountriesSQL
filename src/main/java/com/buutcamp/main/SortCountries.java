package com.buutcamp.main;

import com.buutcamp.entity.VisitedCountry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SortCountries {
    public void sortList(List<VisitedCountry> countries) {
        int i,j;
        VisitedCountry varasto;
        for (i = 1; i < countries.size(); i++){
            j=i;
            while(countries.get(j).getName().compareTo(countries.get(j-1).getName())<0){
                if (j > 0) {
                    varasto = countries.get(j);
                    countries.set(j,countries.get(j-1));
                    countries.set((j-1),varasto);
                    if (j>1){
                        j = j-1;
                    }
                }
            }
        }
    }
}
