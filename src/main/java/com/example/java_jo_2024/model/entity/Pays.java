package com.example.java_jo_2024.model.entity;

public class Pays {
    private String iso3;
    private String name;
    private String capital;
    private String flag;
    private String population;
    private String facts;

    public Pays(String iso3, String name, String capital, String flag, String population, String facts) {
        this.iso3 = iso3;
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.population = population;
        this.facts = facts;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFacts() {
        return facts;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }
}
