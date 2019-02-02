package com.example.rottan.starwarsencyclopedia.Presenter;

import com.example.rottan.starwarsencyclopedia.Controller.PeopleController;
import com.example.rottan.starwarsencyclopedia.Model.People;
import com.example.rottan.starwarsencyclopedia.Model.PeopleSearchResult;
import com.example.rottan.starwarsencyclopedia.Service.PeopleService;
import com.example.rottan.starwarsencyclopedia.View.PeopleView;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeoplePresenter {


    private PeopleController peopleController;
    private PeopleView peopleView;
    private PeopleService peopleService;

    public PeoplePresenter(PeopleView view) {
        this.peopleView = view;

        if (this.peopleService == null) {
            this.peopleService = new PeopleService();
        }
    }

    public void getPeople(int id) {
        peopleService
                .getAPI()
                .getPerson(id)
                .enqueue(new Callback<People>() {

                    @Override
                    public void onResponse(Call<People> call, Response<People> response) {
                        People people = response.body();
                        if (!response.isSuccessful() || people == null) {

                            System.out.println(response.code());
                            System.out.println(".......................................................response code");
                            return;
                        }


                        People personNew = new People();

                        personNew.setName(people.getName());
                        personNew.setGender(people.getGender());

                        List<People> result = new LinkedList<>();
                        result.add(personNew);
                        peopleView.peopleReady(result);

                    }


                    @Override
                    public void onFailure(Call<People> call, Throwable t) {
                        System.out.println(t.getMessage());
                        System.out.println("......................................on failure");
                    }

                });


    }

    public void getSearchedPerson(String url) {
        peopleService
                .getAPI()
                .getSearchedPerson(url)
                .enqueue(new Callback<PeopleSearchResult>() {

                    @Override
                    public void onResponse(Call<PeopleSearchResult> call, Response<PeopleSearchResult> response) {
                        PeopleSearchResult peopleSearchResult = response.body();
                        if (!response.isSuccessful() || peopleSearchResult == null || peopleSearchResult.getPerson().size() == 0) {

                            System.out.println(response.code());
                            System.out.println(".......................................................response code");
                            return;
                        }


                        People personNew = new People();

                        personNew.setName(peopleSearchResult.getPerson().get(0).getName());
                        personNew.setGender(peopleSearchResult.getPerson().get(0).getGender());

                        List<People> result = new LinkedList<>();
                        result.add(personNew);
                        peopleView.peopleReady(result);

                    }

                    @Override
                    public void onFailure(Call<PeopleSearchResult> call, Throwable t) {
                        System.out.println(t.getMessage());
                        System.out.println("......................................on failure");
                    }


                });


    }
}



