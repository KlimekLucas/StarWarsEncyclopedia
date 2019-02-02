package com.example.rottan.starwarsencyclopedia.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleSearchResult {

    @SerializedName("results")
   private List<People> person;

    public List<People> getPerson() {
        return person;
    }

    public void setPerson(List<People> person) {
        this.person = person;
    }
}
