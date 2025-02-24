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
		City tokyo = new City("Tokyo", "The Peninsula Tokyo");
		City rome = new City("Rome", "Hotel de Russie");
		City sydney = new City("Sydney", "The Langham Sydney");
		City berlin = new City("Berlin", "Hotel Adlon Kempinski");
		City madrid = new City("Madrid", "Hotel Ritz Madrid");
		City losAngeles = new City("Los Angeles", "The Beverly Hills Hotel");
		City dubai = new City("Dubai", "Burj Al Arab Jumeirah");
		City amsterdam = new City("Amsterdam", "Hotel De L’Europe");
		City barcelona = new City("Barcelona", "Hotel Arts Barcelona");
		City venice = new City("Venice", "Aman Venice");
		City prague = new City("Prague", "Four Seasons Hotel Prague");

		cityRepository.save(paris);
		cityRepository.save(newYork);
		cityRepository.save(london);
		cityRepository.save(tokyo);
		cityRepository.save(rome);
		cityRepository.save(sydney);
		cityRepository.save(berlin);
		cityRepository.save(madrid);
		cityRepository.save(losAngeles);
		cityRepository.save(dubai);
		cityRepository.save(amsterdam);
		cityRepository.save(barcelona);
		cityRepository.save(venice);
		cityRepository.save(prague);
	}
}
