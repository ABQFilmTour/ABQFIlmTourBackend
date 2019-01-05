package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserCommentRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
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

  /**
   * Instantiates a new User controller.
   *
   * @param userRepository the user repository
   * @param userCommentRepository the user comment repository
   */
  @Autowired
  public UserController(UserRepository userRepository,
      UserCommentRepository userCommentRepository) {
    this.userRepository = userRepository;
    this.userCommentRepository = userCommentRepository;
  }

  /**
   * GETs a list of users ordered by their ID.
   *
   * @return a list of users ordered by their ID.
   */
  @ApiOperation(value = "Gets all users", notes = "Retrieves all users with their ID in an list.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<GoogleUser> list() {
    return userRepository.findAllByOrderByCreatedDesc();
  }

  /**
   * Post response entity.
   *
   * @param googleUser the google user
   * @return the response entity
   */
  @ApiOperation(value = "Posts a google user.", notes = "Posts a googel user.")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GoogleUser> post(@RequestBody GoogleUser googleUser) {
    userRepository.save(googleUser);
    return ResponseEntity.created(googleUser.getHref()).body(googleUser);
  }

  /**
   * Get google user.
   *
   * @param userId the user id
   * @return the google user
   */
  @ApiOperation(value = "Gets google user", notes = "Gets google user id and returns google user.")
  @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public GoogleUser get(@PathVariable("userId") UUID userId) {
    return userRepository.findById(userId).get();
  }

  /**
   * Delete.
   *
   * @param userId the user id
   */
  @ApiOperation(value = "Deletes google user", notes = "Takes user id as a parameter and deletes google user.")
  @Transactional
  @DeleteMapping(value = "{userId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("userId") UUID userId) {
    GoogleUser user = userRepository.findById(userId).get();
    List<UserComment> userComments = userCommentRepository.findAllByUser(user);
    for (UserComment comment : userComments) {
      userCommentRepository.delete(comment);
    }
    userRepository.delete(user);
  }

  /**
   * Patches a user. This will overwrite everything. if just changing one field all other current
   * fields must be included.
   *
   * @param user an updated user.
   */
  @ApiOperation(value = "Patches a google user", notes = "Patches a user. This will overwrite everything. if just changing one field all other current fields must be included.")
  @PatchMapping
  public void patch(@RequestBody GoogleUser user) {
    userRepository.save(user);
  }

}
