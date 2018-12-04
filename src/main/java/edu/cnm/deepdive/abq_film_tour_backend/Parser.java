package edu.cnm.deepdive.abq_film_tour_backend;

import edu.cnm.deepdive.abq_film_tour_backend.controller.FilmLocationController;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class Parser {

  public static final int INDEX_TITLE = 1;
  public static final int INDEX_TYPE = 2;
  public static final int INDEX_IMDB = 3;
  public static final int INDEX_ADDRESS = 4;
  public static final int INDEX_SITE = 5;
  public static final int INDEX_SHOOTDATE = 6;
  public static final int INDEX_ORIGINALDETAILS = 7;
  public static final int INDEX_GEO_X = 8;
  public static final int INDEX_GEO_Y = 9;
  public static final int URL_SUBSTRING_BEGIN = 26;
  public static final int URL_SUBSTRING_END = 35;

  public static final String NULL_STRING = "null";
  public static final String NOT_APPLICABLE = "na";
  public static final String RESOURCE_FILE = "cityfilmlocations.csv";
  public static final String CITY_USER_NAME = "City of Albuquerque";

  @Autowired
  FilmLocationRepository filmLocationRepository;

  @Autowired
  ProductionRepository productionRepository;

  public void postSomething() throws IOException {
    FilmLocation newLocation = new FilmLocation();
    newLocation.setSiteName("churchs chicken");
    System.out.println("I did something");
  }

  public void populateDatabase() throws IOException {
    //TODO Only run this if database has not already been populated
    int failures = 0;
    int successes = 0;
    GoogleUser cityUser = new GoogleUser();
    cityUser.setGoogleName(CITY_USER_NAME);
    FileInputStream fileInputStream = new FileInputStream(RESOURCE_FILE);
    System.out.println("Populating database...");
    InputStreamReader reader = new InputStreamReader(fileInputStream);
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withQuote(null));
    for (CSVRecord record : csvParser.getRecords()) {
      System.out.println(record);
      if (record.getRecordNumber() > 1) {
        try {
          FilmLocation newLocation = new FilmLocation();
          if (!record.get(INDEX_IMDB).equals(NOT_APPLICABLE))
            newLocation.setImdbId(record.get(INDEX_IMDB)
                .substring(URL_SUBSTRING_BEGIN, URL_SUBSTRING_END)); //Slices the ID from the URL
          newLocation.setLatCoordinate(Double.valueOf(record.get(INDEX_GEO_X)));
          newLocation.setLongCoordinate(Double.valueOf(record.get(INDEX_GEO_Y)));
          newLocation.setAddress(record.get(INDEX_ADDRESS));
          newLocation.setSiteName(record.get(INDEX_SITE));
          if (!record.get(INDEX_SHOOTDATE).equals(NULL_STRING)) newLocation.setShootDate(Long.valueOf(record.get(INDEX_SHOOTDATE)));
          newLocation.setOriginalDetails(record.get(INDEX_ORIGINALDETAILS)); //TODO Post to a comment
          successes++;
          filmLocationRepository.save(newLocation);
        } catch (NumberFormatException | DataIntegrityViolationException | DataException e) {
          System.out.println("Failed, skipping.");
          failures++;
        }
      }
    }
    System.out.println(String.format("Added %d locations, %d failures.", successes, failures));
  }
}
