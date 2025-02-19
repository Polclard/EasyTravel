package org.easytravel.service.implementation;

import lombok.AllArgsConstructor;
import org.easytravel.model.City;
import org.easytravel.model.exceptions.CityNotFoundException;
import org.easytravel.model.exceptions.CityWithThatNameAlreadyExists;
import org.easytravel.repository.CityRepository;
import org.easytravel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImplementation implements CityService {

    @Autowired
    private final CityRepository cityRepository;

    @Override
    public City createCity(String cityName) {
        if (cityRepository.existsByName(cityName)) {
            throw new CityWithThatNameAlreadyExists(cityName);
        }
        return cityRepository.save(
                new City(cityName = cityName)
        );
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCity(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(CityNotFoundException::new);
    }

    @Override
    public City updateCity(Long cityId, String cityName) {
        City city = cityRepository.findById(cityId).orElseThrow(CityNotFoundException::new);
        city.setName(cityName);
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(City city) {
        if (cityRepository.existsById(city.getId())) {
            cityRepository.delete(city);
        }
    }

    @Override
    public void deleteCity(Long cityId) {
        if (cityRepository.existsById(cityId)) {
            cityRepository.delete(cityRepository.findById(cityId).orElseThrow(CityNotFoundException::new));
        }
    }

    @Override
    public City detailsCity(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(CityNotFoundException::new);
    }

    @Override
    public City findCityByName(String cityName) {
        return cityRepository.findByName(cityName).orElseThrow(CityNotFoundException::new);
    }
}
