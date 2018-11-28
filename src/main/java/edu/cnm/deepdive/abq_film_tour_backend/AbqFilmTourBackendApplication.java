package edu.cnm.deepdive.abq_film_tour_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;

@EnableEntityLinks
@SpringBootApplication
public class AbqFilmTourBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(AbqFilmTourBackendApplication.class, args);
  }
}
