package org.easytravel.repository;

import org.easytravel.model.City;
import org.easytravel.model.RidePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RidePostRepository extends JpaRepository<RidePost, Long> {

    Optional<List<RidePost>> findByFromCityAndToCity(City fromCity, City toCity);
}
