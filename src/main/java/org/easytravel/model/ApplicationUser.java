package org.easytravel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "application_users")
@Getter
@Setter
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    private String phoneNumber;
    private String password;

    @OneToMany(mappedBy = "driver")
    private List<RidePost> ridePosts;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;


    public ApplicationUser() {}
    public ApplicationUser(String email, String password, String phoneNumber, String username) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.username = username;
        ridePosts = new ArrayList<>();
        bookings = new ArrayList<>();
    }

}
