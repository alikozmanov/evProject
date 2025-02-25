package fr.fms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "T_Hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "bedrooms")
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

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonIgnore // Evite la sérialisation
    private City city;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore // Evite la sérialisation
    private Collection<Bedroom> bedrooms = new ArrayList<>(); // Initialiser à vide


    public Hotel(String name, String address, String phone, int stars, int rooms, double priceMin, City city) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.stars = stars;
        this.rooms = rooms;
        this.priceMin = priceMin;
        this.city = city;
        this.bedrooms = new ArrayList<>(); // Initialisation avec une collection vide
    }
}
