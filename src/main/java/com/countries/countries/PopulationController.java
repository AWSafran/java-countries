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
    @GetMapping(value="/size/{number}")
    public ResponseEntity<?> populationSize(@PathVariable long number)
    {
        ArrayList<Country> bigCountries = new ArrayList<>();
        
        bigCountries = CountriesApplication.listOfCountries.findCountries(c -> c.getPopulation() >= number);
        return new ResponseEntity<>(bigCountries, HttpStatus.OK);
    }

}
