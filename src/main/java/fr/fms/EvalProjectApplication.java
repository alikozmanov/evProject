package fr.fms;

import fr.fms.dao.CityRepository;
import fr.fms.dao.HotelRepository;
import fr.fms.dao.BedroomRepository;
import fr.fms.dao.UserRepository;
import fr.fms.dao.ReservationRepository;
import fr.fms.entities.City;
import fr.fms.entities.Hotel;
import fr.fms.entities.Bedroom;
import fr.fms.entities.User;
import fr.fms.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class EvalProjectApplication implements CommandLineRunner {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private BedroomRepository bedroomRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	public static void main(String[] args) {
		SpringApplication.run(EvalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		generateDatas();
	}

	private void generateDatas() {
		City paris = new City("Paris", "Hyatt Regency Paris Étoile");
		City newYork = new City("New York", "Colgate Inn");
		City london = new City("London", "The Ritz London");
		City tokyo = new City("Tokyo", "Hotel Tokyo Bay");

		cityRepository.save(paris);
		cityRepository.save(newYork);
		cityRepository.save(london);
		cityRepository.save(tokyo);

		// Création des hôtels associés aux villes
		Hotel parisHotel = new Hotel("Hyatt Regency Paris", "Paris, France", "01 44 05 85 00", 5, 200, 150.00, paris);
		Hotel newYorkHotel = new Hotel("Colgate Inn", "New York, USA", "212-123-4567", 4, 100, 120.00, newYork);
		Hotel londonHotel = new Hotel("The Ritz London", "London, UK", "020 7493 8181", 5, 150, 300.00, london);
		Hotel tokyoHotel = new Hotel("Hotel Tokyo Bay", "Tokyo, Japan", "03-5555-6666", 4, 120, 180.00, tokyo);

		hotelRepository.save(parisHotel);
		hotelRepository.save(newYorkHotel);
		hotelRepository.save(londonHotel);
		hotelRepository.save(tokyoHotel);

		// Création des chambres pour Paris
		Bedroom parisBedroom1 = new Bedroom("Suite", 250.00, parisHotel);
		Bedroom parisBedroom2 = new Bedroom("Standard", 150.00, parisHotel);
		Bedroom parisBedroom3 = new Bedroom("Penthouse", 400.00, parisHotel);

		// Création des chambres pour New York
		Bedroom newYorkBedroom1 = new Bedroom("Luxury Suite", 350.00, newYorkHotel);
		Bedroom newYorkBedroom2 = new Bedroom("Double Room", 180.00, newYorkHotel);

		// Création des chambres pour Londres
		Bedroom londonBedroom1 = new Bedroom("Royal Suite", 500.00, londonHotel);
		Bedroom londonBedroom2 = new Bedroom("Executive Room", 250.00, londonHotel);

		// Création des chambres pour Tokyo
		Bedroom tokyoBedroom1 = new Bedroom("Ocean View Room", 200.00, tokyoHotel);
		Bedroom tokyoBedroom2 = new Bedroom("Standard Room", 120.00, tokyoHotel);

		bedroomRepository.save(parisBedroom1);
		bedroomRepository.save(parisBedroom2);
		bedroomRepository.save(parisBedroom3);
		bedroomRepository.save(newYorkBedroom1);
		bedroomRepository.save(newYorkBedroom2);
		bedroomRepository.save(londonBedroom1);
		bedroomRepository.save(londonBedroom2);
		bedroomRepository.save(tokyoBedroom1);
		bedroomRepository.save(tokyoBedroom2);
	}


}
