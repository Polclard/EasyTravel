package org.easytravel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ride_posts")
@Getter
@Setter
public class RidePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private ApplicationUser driver;

    @ManyToOne
    @JoinColumn(name = "from_city_id", nullable = false)
    private City fromCity;

    @ManyToOne
    @JoinColumn(name = "to_city_id", nullable = false)
    private City toCity;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private Integer availableSeats;

    @OneToMany(mappedBy = "ridePost")
    private List<Booking> bookings;

    public RidePost() {}
    public RidePost(ApplicationUser driver, City fromCity, City toCity, Integer availableSeats) {
        this.driver = driver;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureTime = LocalDateTime.now();
        this.availableSeats = availableSeats;
    }

    public RidePost(ApplicationUser driver, City fromCity, City toCity, LocalDateTime departureTime, Integer availableSeats) {
        this.driver = driver;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }
}
