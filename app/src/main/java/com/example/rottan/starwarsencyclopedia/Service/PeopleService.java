package com.example.rottan.starwarsencyclopedia.Service;

import com.example.rottan.starwarsencyclopedia.Controller.PeopleController;
import com.example.rottan.starwarsencyclopedia.Controller.StarshipsController;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleService {

    private Retrofit retrofit = null;



    public PeopleController getAPI() {
        String BASE_URL = "https://swapi.co/api/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(PeopleController.class);
    }
}


