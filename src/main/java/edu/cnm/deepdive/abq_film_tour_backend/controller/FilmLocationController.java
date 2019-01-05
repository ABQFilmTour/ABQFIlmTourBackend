package edu.cnm.deepdive.abq_film_tour_backend.controller;

import static edu.cnm.deepdive.abq_film_tour_backend.controller.Constants.*;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserCommentRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
 * and Images associated with the entity. Requires an associated GoogleUser.
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
   * Gets all the FilmLocations in the database.
   *
   * @return a list of Film Locations ordered by their time of creation.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = FILM_LOCATION_LIST_SUMMARY, notes = FILM_LOCATION_LIST_DESC)
  public List<FilmLocation> list() {
    return filmLocationRepository.findAllByOrderByCreatedDesc();
  }

  /**
   * Gets a FilmLocation.
   *
   * @param filmLocationId the film location id
   * @return the film location
   */
  @GetMapping(value = "{filmLocationId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = FILM_LOCATION_GET_SUMMARY, notes = FILM_LOCATION_GET_DESC)
  public FilmLocation get(@PathVariable("filmLocationId") UUID filmLocationId) {
    return filmLocationRepository.findById(filmLocationId).get();
  }

  /**
   * Posts a new FilmLocation. Requires a Google ID to connect a user to (the submitter), will connect a
   * production to the FilmLocation if a production ID is provided. Should include a site name and long and lat coordinates.
   *
   * @param filmLocation the film location
   * @return the response entity
   */
  @ApiOperation(value = FILM_LOCATION_POST_SUMMARY, notes = FILM_LOCATION_POST_DESC)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FilmLocation> post(@RequestBody FilmLocation filmLocation) {
    if (filmLocation.getProductionId() != null) {
      filmLocation.setProduction(
          productionRepository.findById(UUID.fromString(filmLocation.getProductionId())).get());
    }
    GoogleUser user = userRepository.findByGoogleId(filmLocation.getGoogleId());
    filmLocation.setGoogleId(filmLocation.getGoogleId());
    filmLocation.setUser(user);
    filmLocationRepository.save(filmLocation);
    return ResponseEntity.created(filmLocation.getHref()).body(filmLocation);
  }

  /**
   * Deletes a FilmLocation. Also deletes all userComments and images associated with the image.
   *
   * @param filmLocationId the film location id
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = FILM_LOCATION_DELETE_SUMMARY, notes = FILM_LOCATION_DELETE_DESC)
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
   * Patches a FilmLocation. All data will be overwritten - current fields to stay the same must be
   * included as well.
   *
   * @param filmLocation the updated film location
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = FILM_LOCATION_PATCH_SUMMARY, notes = FILM_LOCATION_PATCH_DESC)
  @PatchMapping
  public void patch(@RequestBody FilmLocation filmLocation) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    filmLocationRepository.save(filmLocation);
  }

  /**
   * Gets all images on a FilmLocation.
   *
   * @param filmLocationId the film location id
   * @return the images
   */
  @ApiOperation(value = IMAGE_LIST_SUMMARY, notes = IMAGE_LIST_DESC)
  @GetMapping(value = "{filmLocationId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Image> getImages(@PathVariable UUID filmLocationId) {
    return imageRepository.findAllByFilmLocationOrderByCreatedDesc
        (filmLocationRepository.findById(filmLocationId).get());
  }

  /**
   * Gets an image.
   *
   * @param filmLocationId the film location id
   * @param imageId the image id
   * @return the image
   */
  @ApiOperation(value = IMAGE_GET_SUMMARY, notes = IMAGE_GET_DESC)
  @GetMapping(value = "{filmLocationId}/images/{imageId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Image getImage(@PathVariable UUID filmLocationId, @PathVariable UUID imageId){
    return imageRepository.findById(imageId).get();
  }

  /**
   * Posts an image to a FilmLocation, referenced by the URL. A user ID is required.
   *
   * @param image the image
   * @param filmLocationId the film location id
   * @return the response entity
   */
  @ApiOperation(value = IMAGE_POST_SUMMARY, notes = IMAGE_POST_DESC)
  @PostMapping(value = "{filmLocationId}/images", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Image> post(@RequestBody Image image,
      @PathVariable UUID filmLocationId) {
    FilmLocation filmLocation = filmLocationRepository.findById(filmLocationId).get();
    GoogleUser user = userRepository.findByGoogleId(image.getGoogleId());
    image.setGoogleId(image.getGoogleId());
    image.setUser(user);
    image.setFilmLocation(filmLocation);
    imageRepository.save(image);
    return ResponseEntity.created(image.getHref()).body(image);
  }

  /**
   * Deletes an image.
   *
   * @param filmLocationId the film location id
   * @param imageId the image id
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = IMAGE_DELETE_SUMMARY, notes = IMAGE_DELETE_DESC)
  @DeleteMapping(value = "{filmLocationId}/images/{imageId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteImage(@PathVariable UUID filmLocationId, @PathVariable("imageId") UUID imageId){
    imageRepository.deleteById(imageId);
  }

  /**
   * Patches an image. All data to stay the same must be included.
   *
   * @param filmLocationId the film location id
   * @param image the updated image
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = IMAGE_PATCH_SUMMARY, notes = IMAGE_PATCH_DESC)
  @PatchMapping(value = "{filmLocationId}/images/")
  public void patch(@PathVariable UUID filmLocationId, @RequestBody Image image) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    imageRepository.save(image);
  }

  /**
   * Gets all user comments on a FilmLocation.
   *
   * @param filmLocationId the film location id
   * @return the user comments
   */
  @ApiOperation(value = USER_COMMENT_LIST_SUMMARY, notes = USER_COMMENT_LIST_DESC)
  @GetMapping(value = "{filmLocationId}/user_comments", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserComment> getUserComments(@PathVariable UUID filmLocationId) {
    return userCommentRepository.findAllByFilmLocationOrderByCreatedDesc
        (filmLocationRepository.findById(filmLocationId).get());
  }

  /**
   * Gets a user comment.
   *
   * @param filmLocationId the film location id
   * @param userCommentId the user comment id
   * @return the user comment
   */
  @ApiOperation(value = USER_COMMENT_GET_SUMMARY, notes = USER_COMMENT_GET_DESC)
  @GetMapping(value = "{filmLocationId}/user_comments/{userCommentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserComment getUserComment(@PathVariable UUID filmLocationId, @PathVariable UUID userCommentId){
    return userCommentRepository.findById(userCommentId).get();
  }

  /**
   * Posts a comment to a FilmLocation, referenced by the URL. A user ID is required.
   *
   * @param userComment the user comment
   * @param filmLocationId the film location id
   * @return the response entity
   */
  @ApiOperation(value = USER_COMMENT_POST_SUMMARY, notes = USER_COMMENT_POST_DESC)
  @PostMapping(value = "{filmLocationId}/user_comments", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserComment> post(@RequestBody UserComment userComment,
      @PathVariable UUID filmLocationId) {
    FilmLocation filmLocation = filmLocationRepository.findById(filmLocationId).get();
    GoogleUser user = userRepository.findByGoogleId(userComment.getGoogleId());
    userComment.setGoogleId(userComment.getGoogleId());
    userComment.setUser(user);
    userComment.setFilmLocation(filmLocation);
    userCommentRepository.save(userComment);
    return ResponseEntity.created(userComment.getHref()).body(userComment);
  }

  /**
   * Deletes a user comment.
   *
   * @param filmLocationId the film location id
   * @param userCommentId the user comment id
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = USER_COMMENT_DELETE_SUMMARY, notes = USER_COMMENT_DELETE_DESC)
  @DeleteMapping(value = "{filmLocationId}/user_comments/{userCommentId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUserComment(@PathVariable UUID filmLocationId, @PathVariable("userCommentId") UUID userCommentId){
    userCommentRepository.deleteById(userCommentId);
  }

  /**
   * Patches a user comment. All data to stay the same must be included.
   *
   * @param filmLocationId the film location id
   * @param userComment the updated user comment
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = USER_COMMENT_PATCH_SUMMARY, notes = USER_COMMENT_PATCH_DESC)
  @PatchMapping(value = "{filmLocationId}/user_comments")
  public void patch(@PathVariable UUID filmLocationId, @RequestBody UserComment userComment) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    userCommentRepository.save(userComment);
  }

}