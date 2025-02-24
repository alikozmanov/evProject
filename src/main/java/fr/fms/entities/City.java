package fr.fms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "T_City")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "hotels")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String hotel;

    @OneToMany(mappedBy = "city")
    private Collection<Hotel> hotels;

    public City(String name, String hotel) {
        this.id = id;
        this.name = name;
        this.hotel = hotel;
    }
}
