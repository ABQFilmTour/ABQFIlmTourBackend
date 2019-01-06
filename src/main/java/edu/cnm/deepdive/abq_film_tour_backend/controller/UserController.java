package edu.cnm.deepdive.abq_film_tour_backend.controller;

import static edu.cnm.deepdive.abq_film_tour_backend.controller.Constants.*;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
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
import org.springframework.security.access.prepost.PreAuthorize;
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
 * Controller for the "GoogleUser" entity. Not required to contain any connections to other
 * entities. This is the most restricted endpoint, only the admin has access.
 */
@RestController
@ExposesResourceFor(GoogleUser.class)
@RequestMapping("/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {

  private UserRepository userRepository;
  private UserCommentRepository userCommentRepository;
  private ImageRepository imageRepository;
  private FilmLocationRepository filmLocationRepository;

  /**
   * Instantiates a new User controller.
   *
   * @param userRepository the user repository
   * @param userCommentRepository the user comment repository
   */
  @Autowired
  public UserController(UserRepository userRepository,
      UserCommentRepository userCommentRepository, ImageRepository imageRepository, FilmLocationRepository filmLocationRepository) {
    this.userRepository = userRepository;
    this.userCommentRepository = userCommentRepository;
    this.imageRepository = imageRepository;
    this.filmLocationRepository = filmLocationRepository;
  }

  /**
   * Gets a list of users ordered by the name on their Google account.
   *
   * @return a list of users ordered by their name.
   */
  @ApiOperation(value = USER_LIST_SUMMARY, notes = USER_LIST_DESC)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<GoogleUser> list() {
    return userRepository.findAllByOrderByGoogleNameAsc();
  }

  /**
   * Get google user by their internal ID.
   *
   * @param userId the internal user ID
   * @return the google user
   */
  @ApiOperation(value = USER_GET_SUMMARY, notes = USER_GET_DESC)
  @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public GoogleUser get(@PathVariable("userId") UUID userId) {
    return userRepository.findById(userId).get();
  }

  /**
   * Posts a new Google user. Should include a Google ID, a name, and an email address.
   *
   * @param googleUser the google user
   * @return the response entity
   */
  @ApiOperation(value = USER_POST_SUMMARY, notes = USER_POST_DESC)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GoogleUser> post(@RequestBody GoogleUser googleUser) {
    userRepository.save(googleUser);
    return ResponseEntity.created(googleUser.getHref()).body(googleUser);
  }

  /**
   * Deletes a Google user.
   *
   * @param userId the user id
   */
  @ApiOperation(value = USER_DELETE_SUMMARY, notes = USER_DELETE_DESC)
  @Transactional
  @DeleteMapping(value = "{userId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("userId") UUID userId) {
    GoogleUser user = userRepository.findById(userId).get();
    userRepository.delete(user);
  }

  /**
   * Patches a user. This will overwrite everything. if just changing one field all other current
   * fields must be included.
   *
   * @param user an updated user.
   */
  @ApiOperation(value = USER_PATCH_SUMMARY, notes = USER_PATCH_DESC)
  @PatchMapping
  public void patch(@RequestBody GoogleUser user) {
    userRepository.save(user);
  }

  /**
   * Gets all of the comments a user has submitted in order of creation
   *
   * @param userId the user UUID
   * @return a list of all comments submitted by a user, in order by the time of creation.
   */
  @ApiOperation(value = USER_LIST_COMMENTS_SUMMARY, notes = USER_LIST_COMMENTS_DESC)
  @GetMapping(value = "{userId}/user_comments", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserComment> getUserComments(@PathVariable UUID userId){
    GoogleUser user = userRepository.findById(userId).get();
    return userCommentRepository.findAllByUserOrderByCreatedDesc(user);
  }

  /**
   * Gets all of the images a user has submitted in order of creation
   *
   * @param userId the user UUID
   * @return a list of all comments submitted by a user, in order by the time of creation.
   */
  @ApiOperation(value = USER_LIST_IMAGES_SUMMARY, notes = USER_LIST_IMAGES_DESC)
  @GetMapping(value = "{userId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Image> getImages(@PathVariable UUID userId){
    GoogleUser user = userRepository.findById(userId).get();
    return imageRepository.findAllByUserOrderByCreatedDesc(user);
  }

  /**
   * Gets all of the film locations a user has submitted in order of creation
   *
   * @param userId the user UUID
   * @return a list of all comments submitted by a user, in order by the time of creation.
   */
  @ApiOperation(value = USER_LIST_LOCATIONS_SUMMARY, notes = USER_LIST_LOCATIONS_DESC)
  @GetMapping(value = "{userId}/film_locations", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<FilmLocation> getFilmLocations(@PathVariable UUID userId){
    GoogleUser user = userRepository.findById(userId).get();
    return filmLocationRepository.findAllByUserOrderByCreatedDesc(user);
  }

  @ApiOperation(value = USER_PURGE_SUMMARY, notes = USER_PURGE_DESC)
  @RequestMapping(value = "{userId}/purge")
  public void purge(@PathVariable UUID userId) {
    GoogleUser user = userRepository.findById(userId).get();
    List<UserComment> userComments = userCommentRepository.findAllByUser(user);
    for (UserComment comment : userComments) {
      userCommentRepository.delete(comment);
    }
    List<Image> images = imageRepository.findAllByUser(user);
    for (Image image : images) {
      imageRepository.delete(image);
    }
    List<FilmLocation> locations = filmLocationRepository.findAllByUser(user);
    for (FilmLocation location : locations) {
      filmLocationRepository.delete(location);
    }
  }
}
