package com.example.java_jo_2024.model.entity;

public class Pays {
    private String iso2;
    private String name;
    private String capital;
    private String flag;
    private String population;
    private String facts;

    public Pays(String iso2, String name, String capital, String flag, String population, String facts) {
        this.iso2 = iso2;
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.population = population;
        this.facts = facts;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
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
