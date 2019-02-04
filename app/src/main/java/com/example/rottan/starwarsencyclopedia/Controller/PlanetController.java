package com.example.rottan.starwarsencyclopedia.Controller;

import com.example.rottan.starwarsencyclopedia.Model.Planet;
import com.example.rottan.starwarsencyclopedia.Model.PlanetSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PlanetController {

    @GET("planet/1")
    Call<Planet> getPlanet();

    @GET
    Call<PlanetSearchResult> getSearchedPlanets(@Url String url);
}
