package org.easytravel.service;

import org.easytravel.model.Booking;
import org.easytravel.model.RidePost;
import java.util.List;

public interface BookingService {
    /**
     * Retrieves all bookings.
     * @return A list of all bookings.
     */
    List<Booking> getAllBookings();
    /**
     * Retrieves bookings for a specific ride post by its ID.
     * @param ridePostId The ID of the ride post to get bookings for.
     * @return A list of bookings related to the specified ride post.
     */
    Booking getBookings(Long ridePostId);
    /**
     * Creates a new booking for a passenger on a specific ride post.
     * @param passengerId The ID of the passenger making the booking.
     * @param ridePostId The ID of the ride post the passenger is booking.
     * @param seatsBooked The number of seats being booked by the passenger.
     * @return The created booking object.
     */
    Booking createBookings(Long passengerId, Long ridePostId, Integer seatsBooked);
    /**
     * Updates an existing booking with new details.
     * @param id The ID of the booking to update.
     * @param passengerId The updated ID of the passenger making the booking.
     * @param ridePostId The updated ID of the ride post the passenger is booking.
     * @param seatsBooked The updated number of seats being booked.
     * @return The updated booking object.
     */
    Booking updateBookings(Long id, Long passengerId, Long ridePostId, Integer seatsBooked);
    /**
     * Deletes a specific booking.
     * @param booking The booking object to delete.
     */
    void deleteBookings(Booking booking);
    /**
     * Deletes a specific booking by its ID.
     * @param bookingId The ID of the booking to delete.
     */
    void deleteBookings(Long bookingId);
    /**
     * Retrieves detailed information about a specific booking.
     * @param bookingId The ID of the booking to retrieve details for.
     * @return The detailed booking object.
     */
    Booking detailsBookings(Long bookingId);
}
