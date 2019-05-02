package com.countries.countries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(value = "/all")
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
    
    //localhost:8080/name/start/a
    //Return countries alphabetically that begin with the given letter
    @GetMapping(value ="/start/{letter}")
    public ResponseEntity<?> namesStartLetter(@PathVariable char letter)
    {
        ArrayList<Country> matchingCountries = new ArrayList<>();
        matchingCountries = CountriesApplication.listOfCountries.findCountries(c -> c.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter));
        matchingCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(matchingCountries, HttpStatus.OK);
    }
    
    //localhost:8080/name/size/2
    //Return countries alphabetically that have name length >= number
    @GetMapping(value = "/size/{length}")
    public ResponseEntity<?> nameLength(@PathVariable int length)
    {
        ArrayList<Country> matchingCountries = new ArrayList<>();
        matchingCountries = CountriesApplication.listOfCountries.findCountries(c -> c.getName().length() >= length);
        matchingCountries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(matchingCountries, HttpStatus.OK);
    }
}
