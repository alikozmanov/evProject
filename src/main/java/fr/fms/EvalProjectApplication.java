package fr.fms;

import fr.fms.dao.CityRepository;
import fr.fms.dao.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.entities.City;
import fr.fms.entities.Hotel;


@SpringBootApplication
public class EvalProjectApplication implements CommandLineRunner {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private HotelRepository hotelRepository;


	public static void main(String[] args) {
		SpringApplication.run(EvalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		generateDatas();
	}

	private void generateDatas() {
		City[] cities = {
				new City("Paris", "/img/hyatt.png"),
				new City("New York", "/img/colgateinn.png"),
				new City("London", "/img/theRitz.png"),
				new City("Tokyo", "/img/hotelTokyoBay.png"),
				new City("Berlin", "/img/hoteladlon.png"),
				new City("Dubai", "/img/burjalarab.png")
		};

		for (City city : cities) {
			cityRepository.save(city);
		}

		Hotel[] hotels = {
				new Hotel("Hyatt Regency", "Paris, France", "01 44 05 85 00", 5, 200, 150.00, cities[0],"/img/hyatt.png"),
				new Hotel("Le Meurice", "Paris, France", "01 44 58 10 10", 5, 150, 400.00, cities[0],"/img/meurice.png"),
				new Hotel("Shangri-La Paris", "Paris, France", "01 53 67 19 98", 5, 120, 350.00, cities[0],"/img/shangri.png"),
				new Hotel("Plaza Athénée", "Paris, France", "01 53 67 66 65", 5, 150, 500.00, cities[0],"/img/plaza.png"),
				new Hotel("Four Seasons Hotel George V", "Paris, France", "01 49 52 70 00", 5, 180, 700.00, cities[0],"/img/george.png"),

				new Hotel("The Plaza", "New York, USA", "212-759-3000", 5, 250, 500.00, cities[1],"/img/plazaNy.png"),
				new Hotel("The Peninsula", "New York, USA", "212-956-2888", 5, 220, 450.00, cities[1],"/img/thepeninsula.png"),
				new Hotel("Waldorf Astoria", "New York, USA", "212-872-7000", 5, 300, 550.00, cities[1],"/img/WaldorfAstoria.png"),
				new Hotel("Park Hyatt", "New York, USA", "646-774-1234", 5, 200, 480.00, cities[1],"/img/parkhyatt.png"),
				new Hotel("St. Regis", "New York, USA", "212-753-4500", 5, 180, 460.00, cities[1],"/img/regis.png"),

				new Hotel("The Ritz", "London, UK", "020 7493 8181", 5, 150, 300.00, cities[2],"/img/ritz.png"),
				new Hotel("The Savoy", "London, UK", "020 7836 4343", 5, 170, 350.00, cities[2],"/img/savoy.png"),
				new Hotel("Claridge's", "London, UK", "020 7629 8860", 5, 140, 400.00, cities[2],"/img/claridges.png"),
				new Hotel("The Dorchester", "London, UK", "020 7629 8888", 5, 180, 420.00, cities[2],"/img/dorchester.png"),
				new Hotel("The Langham", "London, UK", "020 7636 1000", 5, 160, 380.00, cities[2],"/img/langham.png"),

				new Hotel("Hotel Tokyo Bay", "Tokyo, Japan", "03-5555-6666", 5, 200, 180.00, cities[3],"/img/bay.png"),
				new Hotel("Imperial Hotel Tokyo", "Tokyo, Japan", "03-3504-1111", 5, 220, 400.00, cities[3],"/img/imperial.png"),
				new Hotel("The Peninsula Tokyo", "Tokyo, Japan", "03-6270-2888", 5, 250, 450.00, cities[3],"/img/penintokyo.png"),
				new Hotel("Shangri-La Hotel Tokyo", "Tokyo, Japan", "03-6739-7888", 5, 150, 380.00, cities[3],"/img/shangritokyo.png"),
				new Hotel("Mandarin Oriental Tokyo", "Tokyo, Japan", "03-3270-8800", 5, 170, 500.00, cities[3],"/img/mandarin.png"),

				new Hotel("Hotel Adlon Kempinski", "Berlin, Germany", "+49 30 2261 0", 5, 220, 350.00, cities[4],"/img/adlon.png"),
				new Hotel("The Ritz-Carlton Berlin", "Berlin, Germany", "+49 30 337777", 5, 200, 400.00, cities[4],"/img/ritzcarlton.png"),
				new Hotel("Grand Hyatt Berlin", "Berlin, Germany", "+49 30 2553 1234", 5, 250, 420.00, cities[4],"/img/grandhyatt.png"),
				new Hotel("Regent Berlin", "Berlin, Germany", "+49 30 2033 8888", 5, 180, 380.00, cities[4],"/img/regent.png"),
				new Hotel("Sofitel Berlin Gendarmenmarkt", "Berlin, Germany", "+49 30 2037 5555", 5, 160, 360.00, cities[4],"/img/sofitel.png"),

				new Hotel("Burj Al Arab", "Dubai, UAE", "+971 4 301 7777", 7, 200, 1000.00, cities[5],"/img/burjalarab.png"),
				new Hotel("Atlantis The Palm", "Dubai, UAE", "+971 4 426 2000", 5, 220, 600.00, cities[5],"/img/atlantis.png"),
				new Hotel("Jumeirah Beach Hotel", "Dubai, UAE", "+971 4 348 0000", 5, 250, 550.00, cities[5],"/img/jumeirah.png"),
				new Hotel("Armani Hotel Dubai", "Dubai, UAE", "+971 4 888 3888", 5, 180, 700.00, cities[5],"/img/armani.png"),
				new Hotel("The Ritz-Carlton Dubai", "Dubai, UAE", "+971 4 399 4000", 5, 160, 500.00, cities[5],"/img/ritzd.png")
		};

		for (Hotel hotel : hotels) {
			hotelRepository.save(hotel);
		}
	}
}
