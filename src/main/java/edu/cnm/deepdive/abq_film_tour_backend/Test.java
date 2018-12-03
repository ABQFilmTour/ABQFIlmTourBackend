package edu.cnm.deepdive.abq_film_tour_backend;

import edu.cnm.deepdive.abq_film_tour_backend.controller.FilmLocationController;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {

  @Autowired
  FilmLocationRepository filmLocationRepository;

  @Autowired
  ProductionRepository productionRepository;

  public void postSomething() throws IOException {
    FilmLocation newLocation = new FilmLocation();
    newLocation.setSiteName("churchs chicken");
    System.out.println("I did something");
    FileInputStream fileInputStream = new FileInputStream("cityfilmlocations.csv");
    InputStreamReader reader = new InputStreamReader(fileInputStream);
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
    for (CSVRecord record : csvParser.getRecords()) {
      if (record.getRecordNumber() == 155) {
        Production production = new Production();
        production.setTitle(record.get(1));
        production.setImdbId(record.get(3));
        productionRepository.save(production);
        System.out.println("I did something else");
      }
    }
    filmLocationRepository.save(newLocation);
  }

  public void populateDatabase() throws IOException {
    FileInputStream fileInputStream = new FileInputStream("cityfilmlocations.txt");
    InputStreamReader reader = new InputStreamReader(fileInputStream);
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
  }

}
