package org.easytravel.service.implementation;

import lombok.AllArgsConstructor;
import org.easytravel.model.RidePost;
import org.easytravel.model.exceptions.ApplicationUserNotFoundException;
import org.easytravel.model.exceptions.CityNotFoundException;
import org.easytravel.model.exceptions.NoRidePostsWithCurrentCitiesSelection;
import org.easytravel.model.exceptions.RidePostNotFoundException;
import org.easytravel.repository.ApplicationUserRepository;
import org.easytravel.repository.CityRepository;
import org.easytravel.repository.RidePostRepository;
import org.easytravel.service.RidePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RidePostImplementation implements RidePostService {

    @Autowired
    private final RidePostRepository ridePostRepository;
    @Autowired
    private final ApplicationUserRepository applicationUserRepository;
    @Autowired
    private final CityRepository cityRepository;

    @Override
    public RidePost createRidePost(Long application_user_id, Long fromCityId, Long toCityId, Integer availableSeats) {
        return ridePostRepository.save(
                new RidePost(
                        applicationUserRepository.findById(application_user_id).orElseThrow(ApplicationUserNotFoundException::new),
                        cityRepository.findById(fromCityId).orElseThrow(CityNotFoundException::new),
                        cityRepository.findById(toCityId).orElseThrow(CityNotFoundException::new),
                        availableSeats
                )
        );
    }

    @Override
    public List<RidePost> getAllRidePosts() {
        return ridePostRepository.findAll();
    }

    @Override
    public RidePost getRidePost(Long ridePostId) {
        return ridePostRepository.findById(ridePostId).orElseThrow(RidePostNotFoundException::new);
    }

    @Override
    public RidePost updateRidePost(Long ridePostId, Long application_user_id, Long fromCityId, Long toCityId, LocalDateTime departureTime, Integer availableSeats) {
        RidePost foundRidePost = ridePostRepository.findById(ridePostId).orElseThrow(RidePostNotFoundException::new);
        foundRidePost.setDriver(applicationUserRepository.findById(application_user_id).orElseThrow(ApplicationUserNotFoundException::new));
        foundRidePost.setFromCity(cityRepository.findById(fromCityId).orElseThrow(CityNotFoundException::new));
        foundRidePost.setToCity(cityRepository.findById(toCityId).orElseThrow(CityNotFoundException::new));
        foundRidePost.setDepartureTime(departureTime);
        foundRidePost.setAvailableSeats(availableSeats);
        return ridePostRepository.save(foundRidePost);
    }

    @Override
    public void deleteRidePost(RidePost ridePost) {
        ridePostRepository.delete(ridePost);
    }

    @Override
    public void deleteRidePost(Long ridePostId) {
        ridePostRepository.delete(ridePostRepository.findById(ridePostId).orElseThrow(RidePostNotFoundException::new));
    }

    @Override
    public RidePost detailsRidePost(Long ridePostId) {
        return ridePostRepository.findById(ridePostId).orElseThrow(RidePostNotFoundException::new);
    }

    @Override
    public List<RidePost> findByFromCityAndToCity(Long fromCityId, Long toCityId) {
        return ridePostRepository
                .findByFromCityAndToCity
                        (
                                cityRepository.findById(fromCityId).orElseThrow(CityNotFoundException::new),
                                cityRepository.findById(toCityId).orElseThrow(CityNotFoundException::new)
                        )
                .orElseThrow(NoRidePostsWithCurrentCitiesSelection::new);
    }
}
