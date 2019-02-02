package com.example.rottan.starwarsencyclopedia.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Starship {

    @SerializedName("name")
    private String name;
    @SerializedName("model")
    private String model;
    @SerializedName("manufacturer")
    private String manufacturer;
    @SerializedName("cost_in_credits")
    private String costInCredits;
    @SerializedName("length")
    private String length;
    @SerializedName("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @SerializedName("crew")
    private String crew;
    @SerializedName("passengers")
    private String passengers;
    @SerializedName("cargo_capacity")
    private String cargoCapacity;
    @SerializedName("consumables")
    private String consumables;
    @SerializedName("hyperdrive_rating")
    private String hyperdriveRating;
    @SerializedName("MGLT")
    private String MGLT;
    @SerializedName("starship_class")
    private String starshipClass;
    @SerializedName("pilots")
    private List<String> pilots;
    @SerializedName("films")
    private List<String> films;
    @SerializedName("created")
    private String created;
    @SerializedName("edited")
    private String edited;
    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public String getLength() {
        return length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public String getMGLT() {
        return MGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public List<String> getFilms() {
        return films;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public void setMGLT(String MGLT) {
        this.MGLT = MGLT;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
