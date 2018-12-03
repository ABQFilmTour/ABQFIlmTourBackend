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
  }

  public void populateDatabase() throws IOException {
    //TODO Only run this if database has not already been populated
    FileInputStream fileInputStream = new FileInputStream("cityfilmlocations.csv");
    System.out.println("Populating database...");
    InputStreamReader reader = new InputStreamReader(fileInputStream);
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withQuote(null));
    for (CSVRecord record : csvParser.getRecords()) {
      //TODO Count the failures
      System.out.println(record);
      if (record.getRecordNumber() > 1) {
        try {
          FilmLocation newLocation = new FilmLocation();
          newLocation.setImdbId(record.get(INDEX_IMDB)); //TODO parse from URL to ID
          newLocation.setAddress(record.get(INDEX_ADDRESS));
          newLocation.setSiteName(record.get(INDEX_SITE));
          if (!record.get(INDEX_SHOOTDATE).equals("null")) newLocation.setShootDate(Long.valueOf(record.get(INDEX_SHOOTDATE)));
          newLocation.setOriginalDetails(record.get(INDEX_ORIGINALDETAILS));
          newLocation.setLatCoordinate(Double.valueOf(record.get(INDEX_GEO_X)));
          newLocation.setLongCoordinate(Double.valueOf(record.get(INDEX_GEO_Y)));
          filmLocationRepository.save(newLocation);
        } catch (NumberFormatException e) {
          System.out.println("Failed, skipping.");
        } catch (DataException e) {
          System.out.println("Failed, skipping");
        } catch (DataIntegrityViolationException e) {
          System.out.println("Failed, Skipping");
        }
      }
    }
    System.out.printf("Done."); //TODO Display failure count
  }
}
