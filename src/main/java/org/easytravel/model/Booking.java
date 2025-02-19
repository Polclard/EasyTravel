package org.easytravel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ride_post_id", nullable = false)
    private RidePost ridePost;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private ApplicationUser passenger;

    @Column(nullable = false)
    private Integer seatsBooked;

    public Booking() {}
    public Booking(ApplicationUser passenger, RidePost ridePost, Integer seatsBooked) {
        this.passenger = passenger;
        this.ridePost = ridePost;
        this.seatsBooked = seatsBooked;
    }

}
