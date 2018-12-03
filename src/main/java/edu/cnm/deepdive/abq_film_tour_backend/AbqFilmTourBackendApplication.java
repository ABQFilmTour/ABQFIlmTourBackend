package edu.cnm.deepdive.abq_film_tour_backend;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.hateoas.config.EnableEntityLinks;

@EnableEntityLinks
@SpringBootApplication
public class AbqFilmTourBackendApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(AbqFilmTourBackendApplication.class, args);
    try {
      context.getBean(Test.class).postSomething();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
