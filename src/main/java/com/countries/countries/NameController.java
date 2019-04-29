package com.countries.countries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@RestController
@RequestMapping("/name")
public class NameController
{
    //localhost:8080/name/all
    //returns name of all countries alphabetically
    @RequestMapping(value = "/all")
    public ResponseEntity<?> getAllNames()
    {
    
        ArrayList<String> countryNames = new ArrayList<String>();
        for (Country c : CountriesApplication.listOfCountries.countryList)
        {
            countryNames.add(c.getName());
        }
        countryNames.sort((c1, c2) -> c1.compareToIgnoreCase(c2));
        return new ResponseEntity<>(countryNames, HttpStatus.OK);
        
    }
}
