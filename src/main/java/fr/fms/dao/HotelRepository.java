package fr.fms.dao;

import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Trouver tous les hôtels d'une ville
    List<Hotel> findByCity(City city);
    List<Hotel> findByNameContainingIgnoreCaseOrCityNameContainingIgnoreCase(String hotelName, String cityName);
}
