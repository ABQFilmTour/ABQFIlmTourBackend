package edu.cnm.deepdive.abq_film_tour_backend;

import edu.cnm.deepdive.abq_film_tour_backend.controller.FilmLocationController;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import java.io.InputStreamReader;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {

  @Autowired
  FilmLocationRepository filmLocationRepository;

  public void postSomething() {
    FilmLocation newLocation = new FilmLocation();
    newLocation.setSiteName("churchs chicken");
    System.out.println("I did something");
    filmLocationRepository.save(newLocation);
  }

//  public void populateDatabase() {
//    CSVParser csvParser = new CSVParser(new InputStreamReader());
//  }

}
