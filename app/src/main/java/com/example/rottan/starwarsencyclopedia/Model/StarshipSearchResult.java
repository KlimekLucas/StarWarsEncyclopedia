package com.example.rottan.starwarsencyclopedia.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarshipSearchResult {

    @SerializedName("results")
    private List<Starship> starship;

    public List<Starship> getStarship() {
        return starship;
    }

    public void setStarship(List<Starship> starship) {
        this.starship = starship;
    }
}
