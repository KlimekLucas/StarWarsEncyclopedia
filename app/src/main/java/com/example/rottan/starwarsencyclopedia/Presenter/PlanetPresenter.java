package com.example.rottan.starwarsencyclopedia.Presenter;

import com.example.rottan.starwarsencyclopedia.Controller.PlanetController;
import com.example.rottan.starwarsencyclopedia.Model.Planet;
import com.example.rottan.starwarsencyclopedia.Service.PeopleService;
import com.example.rottan.starwarsencyclopedia.Service.PlanetService;
import com.example.rottan.starwarsencyclopedia.View.PeopleView;
import com.example.rottan.starwarsencyclopedia.View.PlanetsView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetPresenter {


    private PlanetController planetController;
    private PlanetsView planetsView;
    private PlanetService planetService;

    public PlanetPresenter(PlanetsView view) {
        this.planetsView = view;

        if (this.planetService == null) {
            this.planetService = new PlanetService();
        }
    }

    public void getPlantet() {
        planetService
                .getAPI()
                .getPlanet()
                .enqueue(new Callback<Planet>() {
                    @Override
                    public void onResponse(Call<Planet> call, Response<Planet> response) {


                    }

                    @Override
                    public void onFailure(Call<Planet> call, Throwable t) {

                    }
                });
    }
}
