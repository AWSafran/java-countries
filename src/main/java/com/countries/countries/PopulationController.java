package com.countries.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    //localhost:8080/population/size/{number}
    //find countries with population >= {number}
    @GetMapping(value="/size/{number}")
    public ResponseEntity<?> populationSize(@PathVariable long number)
    {
        ArrayList<Country> bigCountries = new ArrayList<>();
        
        bigCountries = CountriesApplication.listOfCountries.findCountries(c -> c.getPopulation() >= number);
        return new ResponseEntity<>(bigCountries, HttpStatus.OK);
    }
    
    //localhost:8080/population/min
    //find minimum population
    @GetMapping(value = "/min")
    public ResponseEntity<?> minPopulation()
    {
        ArrayList<Country> orderedCountries = new ArrayList<>();
        
        for (Country c : CountriesApplication.listOfCountries.countryList)
        {
            orderedCountries.add(c);
        }
        
        orderedCountries.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        
        return new ResponseEntity<>(orderedCountries.get(0), HttpStatus.OK);
    }
    
    @GetMapping(value = "/max")
    public ResponseEntity<?> maxPopulation()
    {
        ArrayList<Country> orderedCountries = new ArrayList<>();
    
        for (Country c : CountriesApplication.listOfCountries.countryList)
        {
            orderedCountries.add(c);
        }
    
        orderedCountries.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
    
        return new ResponseEntity<>(orderedCountries.get(0), HttpStatus.OK);
    }
    
    //STRETCH GOAL
    //localhost:8080/population/median
    //Get country with median population
    @GetMapping(value = "/median")
    public ResponseEntity<?> medianPop()
    {
        CountriesApplication.listOfCountries.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        
        return new ResponseEntity<>(CountriesApplication.listOfCountries.countryList.get(CountriesApplication.listOfCountries.countryList.size() / 2), HttpStatus.OK);
    }

}
