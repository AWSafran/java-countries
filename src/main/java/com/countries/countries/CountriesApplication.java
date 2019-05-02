package com.countries.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class CountriesApplication
{
    static CountryList listOfCountries;
    public static void main(String[] args)
    {
        listOfCountries = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
