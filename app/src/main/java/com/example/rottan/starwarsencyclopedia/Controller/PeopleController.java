package com.example.rottan.starwarsencyclopedia.Controller;

import com.example.rottan.starwarsencyclopedia.Model.People;
import com.example.rottan.starwarsencyclopedia.Model.PeopleSearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PeopleController {

    @GET("people")
    Call<List<People>> getPeople();


    @GET("people/{id}")
    Call<People> getPerson(@Path("id") int id);

    @GET
    Call<PeopleSearchResult> getSearchedPerson (@Url String url);


     // @GET("https://swapi.co/api/people/?search={name}")
     //  Call<People> getPerson(@Path("name") String name);
}
