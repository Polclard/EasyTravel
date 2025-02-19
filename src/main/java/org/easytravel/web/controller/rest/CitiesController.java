package org.easytravel.web.controller.rest;

import lombok.AllArgsConstructor;
import org.easytravel.model.City;
import org.easytravel.model.dto.CityDTO;
import org.easytravel.model.exceptions.CityWithThatNameAlreadyExists;
import org.easytravel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = {"/api/cities"})
@CrossOrigin(origins = {"*"})
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

    @PostMapping("/create")
    public ResponseEntity<?> createCity(@RequestBody CityDTO cityDTO) {
        try
        {
            City savedCity = cityService.createCity(cityDTO.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCity);
        }
        catch (CityWithThatNameAlreadyExists exception)
        {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(exception.getMessage());
        }
    }

}
