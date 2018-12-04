package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserCommentRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller for the FilmLocation entity, which also includes functionality for userComments
 * and Images associated with the entity.
 */
@RestController
@ExposesResourceFor(FilmLocation.class)
@RequestMapping("/film_locations")
public class FilmLocationController {

  private FilmLocationRepository filmLocationRepository;
  private UserCommentRepository userCommentRepository;
  private UserRepository userRepository;
  private ImageRepository imageRepository;
  private ProductionRepository productionRepository;

  /**
   * Instantiates a new Film location controller.
   *
   * @param filmLocationRepository the film location repository
   * @param userCommentRepository the user comment repository
   * @param userRepository the user repository
   * @param imageRepository the image repository
   * @param productionRepository the production repository
   */
  @Autowired
  public FilmLocationController(FilmLocationRepository filmLocationRepository,
      UserCommentRepository userCommentRepository,
      UserRepository userRepository,
      ImageRepository imageRepository,
      ProductionRepository productionRepository) {
    this.filmLocationRepository = filmLocationRepository;
    this.userCommentRepository = userCommentRepository;
    this.userRepository = userRepository;
    this.imageRepository = imageRepository;
    this.productionRepository = productionRepository;
  }

  /**
   * GETs all the FilmLocations in the database.
   *
   * @return the list
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<FilmLocation> list() {
    return filmLocationRepository.findAllByOrderByIdAsc();
  }

  /**
   * POSTs a FilmLocation. Requires a user ID to connect a user to (the submitter), will connect a
   * production to the FilmLocation if a production ID is provided.
   *
   * @param filmLocation the film location
   * @return the response entity
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FilmLocation> post(@RequestBody FilmLocation filmLocation) {
    if (filmLocation.getProductionId() != null) {
      filmLocation.setProduction(
          productionRepository.findById(UUID.fromString(filmLocation.getProductionId())).get());
    }
    GoogleUser user = userRepository.findById(filmLocation.getUserId()).get();
    filmLocation.setUserId(filmLocation.getUserId());
    filmLocation.setUser(user);
    filmLocationRepository.save(filmLocation);
    return ResponseEntity.created(filmLocation.getHref()).body(filmLocation);
  }

  /**
   * GETs a FilmLocation.
   *
   * @param filmLocationId the film location id
   * @return the film location
   */
  @GetMapping(value = "{filmLocationId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public FilmLocation get(@PathVariable("filmLocationId") UUID filmLocationId) {
    return filmLocationRepository.findById(filmLocationId).get();
  }

  /**
   * PATCHes a FilmLocation. All data will be overwritten - current fields to stay the same must be
   * included as well.
   *
   * @param filmLocation the film location
   */
  @PatchMapping
  public void patch(@RequestBody FilmLocation filmLocation) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    filmLocationRepository.save(filmLocation);
  }

  /**
   * DELETEs a FilmLocation. Also deletes all userComments and images associated with the image.
   *
   * @param filmLocationId the film location id
   */
  @Transactional
  @DeleteMapping(value = "{filmLocationId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("filmLocationId") UUID filmLocationId){
    FilmLocation filmLocation = filmLocationRepository.findById(filmLocationId).get();
    List<UserComment> userComments = userCommentRepository.
        findAllByFilmLocationOrderByCreatedDesc(filmLocation);
    List<Image> images = imageRepository.findAllByFilmLocationOrderByCreatedDesc(filmLocation);
    for (UserComment comment : userComments) {
      userCommentRepository.delete(comment);
    }
    for (Image image : images) {
      imageRepository.delete(image);
    }
    filmLocationRepository.delete(filmLocation);
  }

  /**
   * POSTs an image to a FilmLocation, referenced by the URL. A user ID is required.
   *
   * @param image the image
   * @param filmLocationId the film location id
   * @return the response entity
   */
  @PostMapping(value = "{filmLocationId}/images", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Image> post(@RequestBody Image image,
      @PathVariable UUID filmLocationId) {
    FilmLocation filmLocation = filmLocationRepository.findById(filmLocationId).get();
    GoogleUser user = userRepository.findById(image.getUserId()).get();
    image.setUserId(image.getUserId());
    image.setUser(user);
    image.setFilmLocation(filmLocation);
    imageRepository.save(image);
    return ResponseEntity.created(image.getHref()).body(image);
  }

  /**
   * GETs all images on a FilmLocation.
   *
   * @param filmLocationId the film location id
   * @return the images
   */
  @GetMapping(value = "{filmLocationId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Image> getImages(@PathVariable UUID filmLocationId) {
    return imageRepository.findAllByFilmLocationOrderByCreatedDesc
        (filmLocationRepository.findById(filmLocationId).get());
  }

  /**
   * GETs an image.
   *
   * @param filmLocationId the film location id
   * @param imageId the image id
   * @return the image
   */
  @GetMapping(value = "{filmLocationId}/images/{imageId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Image getImage(@PathVariable UUID filmLocationId, @PathVariable UUID imageId){
    Image image = imageRepository.findById(imageId).get();
    return image;
  }

  /**
   * DELETES an image.
   *
   * @param filmLocationId the film location id
   * @param imageId the image id
   */
  @DeleteMapping(value = "{filmLocationId}/images/{imageId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteImage(@PathVariable UUID filmLocationId, @PathVariable("imageId") UUID imageId){
    imageRepository.deleteById(imageId);
  }

  /**
   * PATCHES an image. All data to stay the same must be included.
   *
   * @param filmLocationId the film location id
   * @param image the image
   */
  @PatchMapping(value="{filmLocationId}/images/")
  public void patch(@PathVariable UUID filmLocationId, @RequestBody Image image) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    imageRepository.save(image);
  }

  /**
   * POSTs a comment to a FilmLocation, referenced by the URL. A user ID is required.
   *
   * @param userComment the user comment
   * @param filmLocationId the film location id
   * @return the response entity
   */
  @PostMapping(value = "{filmLocationId}/user_comments", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserComment> post(@RequestBody UserComment userComment,
      @PathVariable UUID filmLocationId) {
    FilmLocation filmLocation = filmLocationRepository.findById(filmLocationId).get();
    GoogleUser user = userRepository.findById(userComment.getUserId()).get();
    userComment.setUserId(userComment.getUserId());
    userComment.setUser(user);
    userComment.setFilmLocation(filmLocation);
    userCommentRepository.save(userComment);
    return ResponseEntity.created(userComment.getHref()).body(userComment);
  }

  /**
   * GETs all user comments on a FilmLocation.
   *
   * @param filmLocationId the film location id
   * @return the user comments
   */
  @GetMapping(value = "{filmLocationId}/user_comments", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserComment> getUserComments(@PathVariable UUID filmLocationId) {
    return userCommentRepository.findAllByFilmLocationOrderByCreatedDesc
        (filmLocationRepository.findById(filmLocationId).get());
  }

  /**
   * GETs a user comment.
   *
   * @param filmLocationId the film location id
   * @param userCommentId the user comment id
   * @return the user comment
   */
  @GetMapping(value = "{filmLocationId}/user_comments/{userCommentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserComment getUserComment(@PathVariable UUID filmLocationId, @PathVariable UUID userCommentId){
    UserComment userComment = userCommentRepository.findById(userCommentId).get();
    return userComment;
  }

  /**
   * DELETES a user comment.
   *
   * @param filmLocationId the film location id
   * @param userCommentId the user comment id
   */
  @DeleteMapping(value = "{filmLocationId}/user_comments/{userCommentId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUserComment(@PathVariable UUID filmLocationId, @PathVariable("userCommentId") UUID userCommentId){
    userCommentRepository.deleteById(userCommentId);
  }

  /**
   * PATCHes a user comment. All data to stay the same must be included.
   *
   * @param filmLocationId the film location id
   * @param userComment the user comment
   */
  @PatchMapping(value="{filmLocationId}/user_comments")
  public void patch(@PathVariable UUID filmLocationId, @RequestBody UserComment userComment) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    userCommentRepository.save(userComment);
  }

}