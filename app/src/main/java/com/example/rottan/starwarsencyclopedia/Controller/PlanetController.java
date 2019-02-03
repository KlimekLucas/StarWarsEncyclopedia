package com.example.rottan.starwarsencyclopedia.Controller;

import android.telecom.Call;

import com.example.rottan.starwarsencyclopedia.Model.People;
import com.example.rottan.starwarsencyclopedia.Model.Planet;

import java.util.List;

import retrofit2.http.GET;

public interface PlanetController {

    @GET("planet/1")
    retrofit2.Call<Planet> getPlanet();
}
