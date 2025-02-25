package fr.fms;

import fr.fms.dao.CityRepository;
import fr.fms.dao.HotelRepository;
import fr.fms.dao.BedroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import fr.fms.entities.Bedroom;

@SpringBootApplication
public class EvalProjectApplication implements CommandLineRunner {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private BedroomRepository bedroomRepository;

	public static void main(String[] args) {
		SpringApplication.run(EvalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		generateDatas();
	}

	private void generateDatas() {
		City[] cities = {
				new City("Paris", "Hyatt Regency Paris Étoile"),
				new City("New York", "Colgate Inn"),
				new City("London", "The Ritz London"),
				new City("Tokyo", "Hotel Tokyo Bay"),
				new City("Berlin", "Hotel Adlon Kempinski"),
				new City("Dubai", "Burj Al Arab")
		};

		for (City city : cities) {
			cityRepository.save(city);
		}

		Hotel[] hotels = {
				new Hotel("Hyatt Regency Paris", "Paris, France", "01 44 05 85 00", 5, 200, 150.00, cities[0]),
				new Hotel("Colgate Inn", "New York, USA", "212-123-4567", 4, 100, 120.00, cities[1]),
				new Hotel("The Ritz London", "London, UK", "020 7493 8181", 5, 150, 300.00, cities[2]),
				new Hotel("Hotel Tokyo Bay", "Tokyo, Japan", "03-5555-6666", 4, 120, 180.00, cities[3]),
				new Hotel("Hotel Adlon Kempinski", "Berlin, Germany", "+49 30 2261 0", 5, 220, 350.00, cities[4]),
				new Hotel("Burj Al Arab", "Dubai, UAE", "+971 4 301 7777", 7, 200, 1000.00, cities[5])
		};

		for (Hotel hotel : hotels) {
			hotelRepository.save(hotel);
		}

		Bedroom[] bedrooms = {
				new Bedroom("Suite", 250.00, hotels[0]),
				new Bedroom("Standard", 150.00, hotels[0]),
				new Bedroom("Penthouse", 400.00, hotels[0]),
				new Bedroom("Luxury Suite", 350.00, hotels[1]),
				new Bedroom("Double Room", 180.00, hotels[1]),
				new Bedroom("Royal Suite", 500.00, hotels[2]),
				new Bedroom("Executive Room", 250.00, hotels[2]),
				new Bedroom("Ocean View Room", 200.00, hotels[3]),
				new Bedroom("Standard Room", 120.00, hotels[3]),
				new Bedroom("Deluxe Room", 300.00, hotels[4]),
				new Bedroom("Presidential Suite", 800.00, hotels[5])
		};

		for (Bedroom bedroom : bedrooms) {
			bedroomRepository.save(bedroom);
		}
	}
}
