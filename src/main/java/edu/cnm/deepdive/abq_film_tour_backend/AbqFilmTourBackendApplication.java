package edu.cnm.deepdive.abq_film_tour_backend;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.hateoas.config.EnableEntityLinks;

/**
 * Master application class with a Main method.
 */
@EnableEntityLinks
@SpringBootApplication
public class AbqFilmTourBackendApplication {

  private static FilmLocationRepository filmLocationRepository;

  /**
   * Instantiates the application class.
   *
   * @param filmLocationRepository the film location repository
   */
  @Autowired
  AbqFilmTourBackendApplication(FilmLocationRepository filmLocationRepository) {
    this.filmLocationRepository = filmLocationRepository;
  }

  /**
   * Main method, will attempt to populate the database from a local CSV file if it is empty.
   *
   * @param args standard String arguments.
   */
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(AbqFilmTourBackendApplication.class, args);
    if (filmLocationRepository.findAllByOrderByIdAsc().size() == 0) { //Populate the database if it's empty
      try {
        context.getBean(Parser.class).populateDatabase();
      } catch (IOException e) {
        System.out.println("Failed to populate database, check your CSV file.");
      }
    }
  }
}
