package com.countries.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController
{
    //localhost:8080/age/age/{age}
    //return countries with median age equal or greater than given age
    @GetMapping("/age/{age}")
    public ResponseEntity<?> ageGreaterThan(@PathVariable int age)
    {
        ArrayList<Country> oldCountries = CountriesApplication.listOfCountries.findCountries((c) -> c.getAge() >= age);
        return new ResponseEntity<>(oldCountries, HttpStatus.OK);
    }
    
    @GetMapping("/min")
    public ResponseEntity<?> minAge()
    {
        CountriesApplication.listOfCountries.countryList.sort((c1, c2) -> c1.getAge() - c2.getAge());
        
        return new ResponseEntity<>(CountriesApplication.listOfCountries.countryList.get(0), HttpStatus.OK);
    }
    
    @GetMapping("/max")
    public ResponseEntity<?> maxAge()
    {
        CountriesApplication.listOfCountries.countryList.sort((c1, c2) -> c2.getAge() - c1.getAge());
    
        return new ResponseEntity<>(CountriesApplication.listOfCountries.countryList.get(0), HttpStatus.OK);
    }
    
    //STRETCH GOAL
    //localhost:8080/age/max
    //Return country with median median age
    @GetMapping("/median")
    public ResponseEntity<?> medianAge()
    {
        CountriesApplication.listOfCountries.countryList.sort((c1, c2) -> c1.getAge() - c2.getAge());
        
        return new ResponseEntity<>(CountriesApplication.listOfCountries.countryList.get(CountriesApplication.listOfCountries.countryList.size() / 2), HttpStatus.OK);
    }
    
}
