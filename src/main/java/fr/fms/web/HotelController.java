package fr.fms.web;

import fr.fms.dao.CityRepository;
import fr.fms.dao.HotelRepository;
import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")  // Permettre l'accès depuis Angular
public class HotelController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // Récupérer toutes les villes
    @GetMapping("/cities")
    public List<City> getCities() {
        return (List<City>) cityRepository.findAll();
    }

    // Récupérer une ville par ID avec ses hôtels
    @GetMapping("/cities/{id}")
    public Optional<City> getCityById(@PathVariable Long id) {
        return cityRepository.findById(id);
    }

    // Récupérer tous les hôtels
    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return (List<Hotel>) hotelRepository.findAll();
    }

    // Rechercher des hôtels par mot-clé
    @GetMapping("/hotels/search")
    public List<Hotel> searchHotels(@RequestParam String keyword) {
        // Recherche par nom d'hôtel ou par ville
        return hotelRepository.findByNameContainingIgnoreCaseOrCityNameContainingIgnoreCase(keyword, keyword);
    }
}

