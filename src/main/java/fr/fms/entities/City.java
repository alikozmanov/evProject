package fr.fms.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "T_City")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String imageUrl; // Champ pour stocker l'URL de l'image

    @OneToMany(mappedBy = "city")
    private Collection<Hotel> hotels;

    // Constructeur sans imageUrl
    public City(String name) {
        this.name = name;
    }

    // Constructeur avec imageUrl
    public City(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
