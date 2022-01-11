package com.example.minim2exemple.API;

public class Repos {
    String name;
    String language;

    public Repos(String name, String languaje) {
        this.name = name;
        this.language = languaje;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguaje() {
        return language;
    }

    public void setLanguajes(String languaje) {
        this.language = languaje;
    }
}
