package com.example.rottan.starwarsencyclopedia.Controller;

import com.example.rottan.starwarsencyclopedia.Model.Starship;
import com.example.rottan.starwarsencyclopedia.Model.StarshipSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface StarshipsController {

    @GET("starships/9")
    Call<Starship> getStarship();

    @GET
    Call<StarshipSearchResult> getSearchedStarship(@Url String url);
}
