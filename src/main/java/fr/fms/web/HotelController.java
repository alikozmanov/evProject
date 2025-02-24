package fr.fms.web;

import fr.fms.dao.CityRepository;
import fr.fms.dao.HotelRepository;
import fr.fms.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HotelController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // Afficher toutes les villes et leurs hôtels associés
    @GetMapping("/cities")
    public String showCities(Model model) {
        // Récupérer toutes les villes
        Iterable<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities); // Ajouter les villes au modèle
        return "cities";
    }

    // Afficher les hôtels d'une ville spécifique
    @GetMapping("/city/{cityId}")
    public String showHotelsInCity(@PathVariable long cityId, Model model) {
        City city = cityRepository.findById(cityId).orElse(null);
        if (city != null) {
            model.addAttribute("city", city);
            model.addAttribute("hotels", city.getHotels()); // Ajouter les hôtels de la ville
        }
        return "cityDetails";
    }
}

