package org.easytravel.web.controller.rest;

import lombok.AllArgsConstructor;
import org.easytravel.model.City;
import org.easytravel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = {"/api/cities"})
public class CitiesController {
    @Autowired
    private CityService cityService;

    @GetMapping()
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public City getAllCities(@PathVariable Long id) {
        return cityService.getCity(id);
    }

}
