package com.example.rottan.starwarsencyclopedia.Service;

import com.example.rottan.starwarsencyclopedia.Model.Starship;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StarshipApi {

    @GET("starships")
    Call<Starship> getResults();
}
