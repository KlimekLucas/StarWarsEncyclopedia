package com.example.rottan.starwarsencyclopedia.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetSearchResult {


    @SerializedName("results")
    private List<Planet> planet;

    public List<Planet> getPlanet() {
        return planet;
    }

    public void setPlanet(List<Planet> planet) {
        this.planet = planet;
    }
}
