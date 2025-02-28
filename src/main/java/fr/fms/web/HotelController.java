package fr.fms.web;

import fr.fms.dao.CityRepository;
import fr.fms.dao.HotelRepository;
import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // Rechercher des hôtels par mot-clé (nom ou ville)
    @GetMapping("/hotels/search")
    public List<Hotel> searchHotels(@RequestParam String keyword) {
        return hotelRepository.findByNameContainingIgnoreCaseOrCityNameContainingIgnoreCase(keyword, keyword);
    }

    // Récupérer un hôtel par ID
    @GetMapping("/hotels/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ajouter un nouvel hôtel
    @PostMapping("/hotels")
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Modifier un hôtel existant
    @PutMapping("/hotels/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable Long id, @RequestBody Hotel hotelDetails) {
        return hotelRepository.findById(id).map(hotel -> {
            hotel.setName(hotelDetails.getName());
            hotel.setAddress(hotelDetails.getAddress());
            hotel.setStars(hotelDetails.getStars());
            hotel.setPriceMin(hotelDetails.getPriceMin());
            hotel.setPhone(hotelDetails.getPhone());
            hotel.setRooms(hotelDetails.getRooms());
            hotel.setImageUrl(hotelDetails.getImageUrl());
            hotelRepository.save(hotel);
            return ResponseEntity.ok(hotel);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Supprimer un hôtel
    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id) {
        return hotelRepository.findById(id).map(hotel -> {
            hotelRepository.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
