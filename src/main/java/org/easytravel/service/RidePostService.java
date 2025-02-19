package org.easytravel.service;

import org.easytravel.model.City;
import org.easytravel.model.RidePost;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RidePostService {
    /**
     * Retrieves all ride posts.
     * @return A list of all ride posts.
     */
    List<RidePost> getAllRidePosts();
    /**
     * Retrieves a specific ride post by its unique identifier.
     * @param ridePostId The ID of the ride post to retrieve.
     * @return The ride post corresponding to the given ID.
     */
    RidePost getRidePost(Long ridePostId);
    /**
     * Creates a new ride post with the given details.
     * @param application_user_id The ID of the user creating the ride post.
     * @param fromCityId The ID of the city from which the ride departs.
     * @param toCityId The ID of the city to which the ride is heading.
     * @param availableSeats The number of available seats for the ride.
     * @return The created ride post object.
     */
    RidePost createRidePost(Long application_user_id, Long fromCityId, Long toCityId, Integer availableSeats);
    /**
     * Updates the details of an existing ride post.
     * @param application_user_id The ID of the user updating the ride post.
     * @param fromCityId The ID of the city from which the ride departs.
     * @param toCityId The ID of the city to which the ride is heading.
     * @param departureTime The departure time for the ride.
     * @param availableSeats The updated number of available seats for the ride.
     * @return The updated ride post object.
     */
    RidePost updateRidePost(Long ridePostId, Long application_user_id, Long fromCityId, Long toCityId, LocalDateTime departureTime, Integer availableSeats);
    /**
     * Deletes a specific ride post.
     * @param ridePost The ride post object to delete.
     * @return The deleted ride post object.
     */
    void deleteRidePost(RidePost ridePost);
    /**
     * Deletes a specific ride post by its ID.
     * @param ridePostId The ID of the ride post to delete.
     */
    void deleteRidePost(Long ridePostId);
    /**
     * Retrieves detailed information about a specific ride post.
     * @param ridePostId The ID of the ride post to retrieve details for.
     */
    RidePost detailsRidePost(Long ridePostId);
    /**
     * Retrives all of the RidePosts from one specific fromCity to specific toCity
     * @param fromCityId Departure city Id
     * @param toCityId Arrival city Id
     * @return List of all the RidePosts from one specific fromCity to specific toCity
     */
    List<RidePost> findByFromCityAndToCity(Long fromCityId, Long toCityId);
}
