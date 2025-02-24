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

		cityRepository.save(paris);
		cityRepository.save(newYork);
		}
	}
