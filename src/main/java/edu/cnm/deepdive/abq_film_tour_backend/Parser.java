package edu.cnm.deepdive.abq_film_tour_backend;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserCommentRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import edu.cnm.deepdive.abq_film_tour_backend.service.ProductionService;
import edu.cnm.deepdive.abq_film_tour_backend.service.RetrofitClientService;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

/**
 * This class exists to populate the database, parsing data from a cityfilmlocations.csv file with
 * permit data retrieved from the city's servers on 12/3/2018.
 */
@Component
public class Parser {

  private static final int INDEX_TITLE = 1;
  private static final int INDEX_TYPE = 2;
  private static final int INDEX_IMDB = 3;
  private static final int INDEX_ADDRESS = 4;
  private static final int INDEX_SITE = 5;
  private static final int INDEX_SHOOTDATE = 6;
  private static final int INDEX_ORIGINALDETAILS = 7;
  private static final int INDEX_GEO_X = 8;
  private static final int INDEX_GEO_Y = 9;
  private static final int URL_SUBSTRING_BEGIN = 26;
  private static final int URL_SUBSTRING_END = 35;

  private static final String NULL_STRING = "null"; //Shows up in original details, etc
  private static final String NOT_APPLICABLE = "na"; //Shows up in some imdb entries
  private static final String NOT_A_NUMBER = "NaN"; //Shows up in some coordinate entries
  private static final String RESOURCE_FILE = "cityfilmlocations.csv";
  private static final String CITY_USER_NAME = "City of Albuquerque";

  private RetrofitClientService retrofitClientService;
  private FilmLocationRepository filmLocationRepository;
  private ProductionRepository productionRepository;
  private UserRepository userRepository;
  private UserCommentRepository userCommentRepository;
  private ImageRepository imageRepository;
  private String apikey;


  /**
   * Instantiates a new Parser.
   *
   * @param filmLocationRepository the film location repository
   * @param productionRepository the production repository
   * @param userRepository the user repository
   * @param userCommentRepository the user comment repository
   * @param imageRepository the image repository
   */
  Parser(FilmLocationRepository filmLocationRepository, ProductionRepository productionRepository,
      UserRepository userRepository, UserCommentRepository userCommentRepository,
      ImageRepository imageRepository, RetrofitClientService retrofitClientService) {
    this.filmLocationRepository = filmLocationRepository;
    this.productionRepository = productionRepository;
    this.userRepository = userRepository;
    this.userCommentRepository = userCommentRepository;
    this.imageRepository = imageRepository;
    this.retrofitClientService = retrofitClientService;
  }

  @Autowired
  @Qualifier("apiKey")
  public void setApikey(String apikey) {
    this.apikey = apikey;
  }

  /**
   * Populates the database from a CSV file converted from the City of Albuquerque JSON data on
   * 12/3/2018. A City of Albuquerque user is created, submits individual Film Locations and
   * comments with some shooting information.
   *
   * @throws IOException the io exception, necessary possibility for CSV parsing.
   */
  void populateDatabase() throws IOException {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    int failures = 0;
    int successes = 0;
    GoogleUser cityUser = new GoogleUser();
    cityUser.setGoogleName(CITY_USER_NAME);
    cityUser.setBanned(false);
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
          parseRecord(record, newLocation);
          String cityPost = createPost(sdf, newLocation);
          UserComment cityUserComment = new UserComment();
          cityUserComment.setUser(cityUser);
          cityUserComment.setFilmLocation(newLocation);
          cityUserComment.setText(cityPost);
          cityUserComment.setApproved(true);
          userCommentRepository.save(cityUserComment);
          successes++;
        } catch (NumberFormatException | DataIntegrityViolationException | DataException e) {
          System.out.println("Failed, skipping.");
          failures++;
        }
      }
    }
    System.out.println(String.format("Added %d locations, %d failures.", successes, failures));
  }


  /**
   * Attempts to parse the records from the CSV file.
   */
  private void parseRecord(CSVRecord record, FilmLocation newLocation) throws IOException {
    if (!record.get(INDEX_IMDB).equals(NOT_APPLICABLE)) {
      newLocation.setImdbId(record.get(INDEX_IMDB)
          .substring(URL_SUBSTRING_BEGIN, URL_SUBSTRING_END)); //Slices the ID from the URL
    }
    newLocation.setProduction(findProduction(newLocation));
    newLocation.setLongCoordinate(Double.valueOf(record.get(INDEX_GEO_X)));
    newLocation.setLatCoordinate(Double.valueOf(record.get(INDEX_GEO_Y)));
    newLocation.setAddress(record.get(INDEX_ADDRESS));
    newLocation.setSiteName(record.get(INDEX_SITE));
    if (!record.get(INDEX_SHOOTDATE).equals(NULL_STRING)) {
      newLocation.setShootDate(Long.valueOf(record.get(INDEX_SHOOTDATE)));
    }
    if (!record.get(INDEX_ORIGINALDETAILS).equals(NULL_STRING)) {
      newLocation.setOriginalDetails(record.get(INDEX_ORIGINALDETAILS));
    }
    newLocation.setApproved(true);
    filmLocationRepository.save(newLocation);
  }

  /**
   * This method retrieves the production information using a given imdbID. If it is not already
   * found in the database, it retrieves the information from the OMDB API.
   *
   * @param newLocation the location to manipulate.
   * @return the production found.
   * @throws IOException an IO exception.
   */
  private Production findProduction(FilmLocation newLocation) throws IOException {
    // FIXME Still some insertion failures (about 35), unsure why.
    Production production = productionRepository.findByImdbId(newLocation.getImdbId());
    if (production == null) {
      production = retrofitClientService.getRetrofit().create(ProductionService.class)
          .get(newLocation.getImdbId(), apikey).execute().body();
      productionRepository.save(production);
    }
    return production;
  }

  /**
   * Generates a user comment with the information from the city data.
   */
  private String createPost(SimpleDateFormat sdf, FilmLocation newLocation) {
    StringBuilder cityPost = new StringBuilder();
    if (newLocation.getShootDate() != 0) {
      cityPost.append("Shot on ");
      cityPost.append(sdf.format(new Date(newLocation.getShootDate())));
    } else {
      cityPost.append("Shot");
    }
    if (newLocation.getAddress() != null) {
      cityPost.append(" at ");
      cityPost.append(newLocation.getAddress());
    }
    if (newLocation.getOriginalDetails() != null) {
      cityPost.append(". ");
      cityPost.append(newLocation.getOriginalDetails());
    }
    return cityPost.toString();
  }



}
