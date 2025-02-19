package org.easytravel.service;

import org.easytravel.model.ApplicationUser;
import org.easytravel.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    /**
     * Retrieves all cities.
     * @return A list of all cities.
     */
    List<City> getAllCities();
    /**
     * Retrieves a city by its unique identifier.
     * @param cityId The ID of the city to retrieve.
     * @return The city corresponding to the given ID.
     */
    City getCity(Long cityId);
    /**
     * Creates a new city with the given name.
     * @param cityName The name of the city to create.
     * @return The created city object.
     */
    City createCity(String cityName);
    /**
     * Updates the details of an existing city.
     * @param cityId The city object containing updated information.
     * @param cityName New name of the city
     * @return The updated city object.
     */
    City updateCity(Long cityId, String cityName);
    /**
     * Deletes the specified city.
     * @param city The city object to delete.
     * @return The deleted city object.
     */
    void deleteCity(City city);
    /**
     * Deletes the specified city.
     * @param cityId The city Id to delete.
     */
    void deleteCity(Long cityId);
    /**
     * Retrieves detailed information about a city by its ID.
     * @param cityId The ID of the city to retrieve details for.
     */
    City detailsCity(Long cityId);
    /**
     * Find city By name
     * @param cityName The city name
     * @return The city with certain name
     */
    City findCityByName(String cityName);
}

