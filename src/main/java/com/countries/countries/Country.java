package com.countries.countries;

public class Country
{
    private String name;
    private long population;
    private long size;
    private int age;
    
    public Country(String name, long population, long size, int age)
    {
        this.name = name;
        this.population = population;
        this.size = size;
        this.age = age;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public long getPopulation()
    {
        return population;
    }
    
    public void setPopulation(long population)
    {
        this.population = population;
    }
    
    public long getSize()
    {
        return size;
    }
    
    public void setSize(long size)
    {
        this.size = size;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
}
