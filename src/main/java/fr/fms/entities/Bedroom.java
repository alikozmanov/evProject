package fr.fms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "T_Bedroom")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "reservations")
public class Bedroom implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false)
    private double pricePerNight;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "bedroom")
    private Collection<Reservation> reservations = new ArrayList<>(); // Initialisation avec une collection vide

    // Constructeur sans collection de réservations
    public Bedroom(String type, double pricePerNight, Hotel hotel) {
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
        this.reservations = new ArrayList<>(); // Initialisation avec une collection vide
    }
}
