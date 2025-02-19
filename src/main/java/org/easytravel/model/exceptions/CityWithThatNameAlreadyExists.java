package org.easytravel.model.exceptions;

public class CityWithThatNameAlreadyExists extends RuntimeException{

    private final String cityName;

    public CityWithThatNameAlreadyExists(String cityName) {
        this.cityName = cityName;
    }

    public String toString() {
        return "City with "+ cityName +" name already exists.";
    }
}
