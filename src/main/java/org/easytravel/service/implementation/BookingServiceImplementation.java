package org.easytravel.service.implementation;

import lombok.RequiredArgsConstructor;
import org.easytravel.model.Booking;
import org.easytravel.model.RidePost;
import org.easytravel.model.exceptions.ApplicationUserNotFoundException;
import org.easytravel.model.exceptions.RidePostNotFoundException;
import org.easytravel.repository.ApplicationUserRepository;
import org.easytravel.repository.BookingRepository;
import org.easytravel.repository.RidePostRepository;
import org.easytravel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImplementation implements BookingService {

    @Autowired
    private final BookingRepository bookingRepository;
    @Autowired
    private final RidePostRepository ridePostRepository;
    @Autowired
    private final ApplicationUserRepository applicationUserRepository;

    //ApplicationUser passenger, RidePost ridePost, Integer seatsBooked
    @Override
    public Booking createBookings(Long passengerId, Long ridePostId, Integer seatsBooked) {
        return bookingRepository.save(
                new Booking(
                        applicationUserRepository.findById(passengerId).orElseThrow(ApplicationUserNotFoundException::new),
                        ridePostRepository.findById(ridePostId).orElseThrow(RidePostNotFoundException::new),
                        seatsBooked
                        )
        );
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookings(Long ridePostId) {
        return bookingRepository.findById(ridePostId).orElseThrow(RidePostNotFoundException::new);
    }

    @Override
    public Booking updateBookings(Long id, Long passengerId, Long ridePostId, Integer seatsBooked) {
        Booking booking = bookingRepository.findById(id).orElseThrow(ApplicationUserNotFoundException::new);
        booking.setPassenger(applicationUserRepository.findById(passengerId).orElseThrow(ApplicationUserNotFoundException::new));
        booking.setRidePost(ridePostRepository.findById(ridePostId).orElseThrow(RidePostNotFoundException::new));
        booking.setSeatsBooked(seatsBooked);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBookings(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    public void deleteBookings(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public Booking detailsBookings(Long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(ApplicationUserNotFoundException::new);
    }
}
