package com.example.rottan.starwarsencyclopedia.Presenter;

import com.example.rottan.starwarsencyclopedia.Controller.StarshipsController;
import com.example.rottan.starwarsencyclopedia.Model.PeopleSearchResult;
import com.example.rottan.starwarsencyclopedia.Model.Starship;
import com.example.rottan.starwarsencyclopedia.Model.StarshipSearchResult;
import com.example.rottan.starwarsencyclopedia.Service.StarshipsService;
import com.example.rottan.starwarsencyclopedia.View.StarshipsView;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarshipPresenter {

    private StarshipsController starshipsController;
    private StarshipsView starshipsView;
    private StarshipsService starshipsService;

    public StarshipPresenter(StarshipsView view) {
        this.starshipsView = view;

        if (this.starshipsService == null) {
            this.starshipsService = new StarshipsService();
        }
    }

    public void getStarship() {
        starshipsService
                .getAPI()
                .getStarship()
                .enqueue(new Callback<Starship>() {

                    @Override
                    public void onResponse(Call<Starship> call, Response<Starship> response) {
                        Starship starship = response.body();
                        if (!response.isSuccessful() && starship == null) {

                            System.out.println(response.code());
                            System.out.println(".......................................................response code");
                            return;
                        }


                        Starship starshipNew = new Starship();

                        starshipNew.setName(starship.getName());
                        starshipNew.setCargoCapacity(starship.getCargoCapacity());

                        List<Starship> result = new LinkedList<>();
                        result.add(starshipNew);
                        starshipsView.starshipsReady(result);

                    }


                    @Override
                    public void onFailure(Call<Starship> call, Throwable t) {
                        System.out.println(t.getMessage());
                        System.out.println("......................................on failure");
                    }

                });


    }


    public void getSearchedStarship(String url) {
        starshipsService
                .getAPI()
                .getSearchedStarship(url)
                .enqueue(new Callback<StarshipSearchResult>() {

                    @Override
                    public void onResponse(Call<StarshipSearchResult> call, Response<StarshipSearchResult> response) {
                        StarshipSearchResult starshipSearchResult = response.body();
                        if (!response.isSuccessful() || starshipSearchResult == null || starshipSearchResult.getStarship().size() == 0) {

                            System.out.println(response.code());
                            System.out.println(".......................................................response code");
                            return;
                        }


                        Starship starshipNew = new Starship();

                        starshipNew.setName(starshipSearchResult.getStarship().get(0).getName());
                        starshipNew.setCargoCapacity(starshipSearchResult.getStarship().get(0).getCargoCapacity());

                        List<Starship> result = new LinkedList<>();
                        result.add(starshipNew);
                        starshipsView.starshipsReady(result);

                    }

                    @Override
                    public void onFailure(Call<StarshipSearchResult> call, Throwable t) {

                    }

                });
    }
}



