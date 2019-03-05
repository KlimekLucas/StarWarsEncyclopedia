package com.example.rottan.starwarsencyclopedia.Presenter;

import android.widget.Toast;

import com.example.rottan.starwarsencyclopedia.Controller.PlanetController;
import com.example.rottan.starwarsencyclopedia.Model.Planet;
import com.example.rottan.starwarsencyclopedia.Model.PlanetSearchResult;
import com.example.rottan.starwarsencyclopedia.Service.PlanetService;
import com.example.rottan.starwarsencyclopedia.View.PlanetsView;

import java.util.LinkedList;
import java.util.List;

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

    public void getSearchedPlanet(String url) {
        planetService
                .getAPI()
                .getSearchedPlanets(url)
                .enqueue(new Callback<PlanetSearchResult>() {
                    @Override
                    public void onResponse(Call<PlanetSearchResult> call, Response<PlanetSearchResult> response) {
                        PlanetSearchResult planetSearchResult = response.body();
                        List<Planet> result = new LinkedList<>();
                        result = planetSearchResult.getPlanet();
                        planetsView.planetsReady(result);
                    }

                    @Override
                    public void onFailure(Call<PlanetSearchResult> call, Throwable t) {
                        System.out.println(t.getMessage());
                        System.out.println("......................................on failure");
                    }

                });

    }
}
