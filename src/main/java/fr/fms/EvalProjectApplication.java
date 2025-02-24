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

		cityRepository.save(paris);
		cityRepository.save(newYork);

		// Création des hôtels associés à Paris
		Hotel parisHotel = new Hotel("Hyatt Regency Paris", "Paris, France", "01 44 05 85 00", 5, 200, 150.00, paris);
		Hotel newYorkHotel = new Hotel("Colgate Inn", "New York, USA", "212-123-4567", 4, 100, 120.00, newYork);

		hotelRepository.save(parisHotel);
		hotelRepository.save(newYorkHotel);

		// Création des chambres pour Paris
		Bedroom parisBedroom1 = new Bedroom("Suite", 250.00, parisHotel);
		Bedroom parisBedroom2 = new Bedroom("Standard", 150.00, parisHotel);

		bedroomRepository.save(parisBedroom1);
		bedroomRepository.save(parisBedroom2);
	}

}
