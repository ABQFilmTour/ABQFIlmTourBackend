package edu.cnm.deepdive.abq_film_tour_backend;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Master application class with a Main method.
 */
@EnableWebSecurity
@EnableEntityLinks
@EnableResourceServer
@SpringBootApplication
public class AbqFilmTourBackendApplication extends ResourceServerConfigurerAdapter {

  @Value("${oauth.clientId}")
  private String clientId;

  private static FilmLocationRepository filmLocationRepository;

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
      //TODO check more efficiently
      try {
        context.getBean(Parser.class).populateDatabase();
      } catch (IOException e) {
        System.out.println("Failed to populate database, check your CSV file.");
      }
    }
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.resourceId(clientId);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests().anyRequest().hasRole("USER");
  }
}