package fr.fms.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "T_Hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"city"}) // Ignore la ville pour éviter la sérialisation infinie
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String address;

    @Column(length = 50)
    private String phone;

    @Column(nullable = false)
    private int stars;

    @Column(nullable = false)
    private int rooms;

    @Column(nullable = false)
    private double priceMin;

    @Column(length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    // Constructeur sans imageUrl
    public Hotel(String name, String address, String phone, int stars, int rooms, double priceMin, City city) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.stars = stars;
        this.rooms = rooms;
        this.priceMin = priceMin;
        this.city = city;
    }

    // Constructeur avec imageUrl
    public Hotel(String name, String address, String phone, int stars, int rooms, double priceMin, City city, String imageUrl) {
        this(name, address, phone, stars, rooms, priceMin, city);
        this.imageUrl = imageUrl;
    }
}
