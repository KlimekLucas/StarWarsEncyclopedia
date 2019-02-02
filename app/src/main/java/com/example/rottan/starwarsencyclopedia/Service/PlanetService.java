package com.example.rottan.starwarsencyclopedia.Service;

import com.example.rottan.starwarsencyclopedia.Controller.PlanetController;
import com.example.rottan.starwarsencyclopedia.Controller.StarshipsController;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlanetService {
    private Retrofit retrofit = null;


    public PlanetController getAPI() {
        String BASE_URL = "https://swapi.co/api/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(PlanetController.class);
    }
}


