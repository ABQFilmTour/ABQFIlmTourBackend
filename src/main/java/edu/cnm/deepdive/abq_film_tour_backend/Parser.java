package edu.cnm.deepdive.abq_film_tour_backend;

import edu.cnm.deepdive.abq_film_tour_backend.controller.FilmLocationController;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserCommentRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
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

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserCommentRepository userCommentRepository;

  @Autowired
  ImageRepository imageRepository;

  public void postSomething() throws IOException {
    FilmLocation newLocation = new FilmLocation();
    newLocation.setSiteName("churchs chicken");
    System.out.println("I did something");
  }

  public void populateDatabase() throws IOException {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    int failures = 0;
    int successes = 0;
    GoogleUser cityUser = new GoogleUser();
    cityUser.setGoogleName(CITY_USER_NAME);
    userRepository.save(cityUser);
    FileInputStream fileInputStream = new FileInputStream(RESOURCE_FILE);
    System.out.println("Populating database...");
    InputStreamReader reader = new InputStreamReader(fileInputStream);
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withQuote(null));
    for (CSVRecord record : csvParser.getRecords()) {
      System.out.println(record);
      if (record.getRecordNumber() > 1) { //Skips header
        try {
          FilmLocation newLocation = new FilmLocation();
          newLocation.setUser(cityUser);
          if (!record.get(INDEX_IMDB).equals(NOT_APPLICABLE))
            newLocation.setImdbId(record.get(INDEX_IMDB)
                .substring(URL_SUBSTRING_BEGIN, URL_SUBSTRING_END)); //Slices the ID from the URL
          newLocation.setLatCoordinate(Double.valueOf(record.get(INDEX_GEO_X)));
          newLocation.setLongCoordinate(Double.valueOf(record.get(INDEX_GEO_Y)));
          newLocation.setAddress(record.get(INDEX_ADDRESS));
          newLocation.setSiteName(record.get(INDEX_SITE));
          if (!record.get(INDEX_SHOOTDATE).equals(NULL_STRING))
            newLocation.setShootDate(Long.valueOf(record.get(INDEX_SHOOTDATE)));
          if (!record.get(INDEX_ORIGINALDETAILS).equals(NULL_STRING))
            newLocation.setOriginalDetails(record.get(INDEX_ORIGINALDETAILS));
          successes++;
          filmLocationRepository.save(newLocation);

          StringBuilder cityPost = new StringBuilder();
          if (newLocation.getShootDate() != 0) {
            cityPost.append("Shot on ");
            cityPost.append(sdf.format(new Date(newLocation.getShootDate())));
          }
          if (newLocation.getAddress() != null) {
            cityPost.append(" at ");
            cityPost.append(newLocation.getAddress());
          }
          if (newLocation.getOriginalDetails() != null) {
            cityPost.append(". ");
            cityPost.append(newLocation.getOriginalDetails());
          }

          UserComment cityUserComment = new UserComment();
          cityUserComment.setUserId(cityUser.getId());
          cityUserComment.setFilmLocation(newLocation);
          cityUserComment.setText(cityPost.toString());
          userCommentRepository.save(cityUserComment);

        } catch (NumberFormatException | DataIntegrityViolationException | DataException e) {
          System.out.println("Failed, skipping.");
          failures++;
        }
      }
    }
    System.out.println(String.format("Added %d locations, %d failures.", successes, failures));
  }
}
