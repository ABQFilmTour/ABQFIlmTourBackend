package edu.cnm.deepdive.abq_film_tour_backend.controller;

import static edu.cnm.deepdive.abq_film_tour_backend.controller.Constants.*;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserCommentRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for the User Comment entity, child of Film Location, requires a User.
 */
@RestController
@ExposesResourceFor(UserComment.class)
@RequestMapping("/user_comments")
public class UserCommentController {

  private UserCommentRepository userCommentRepository;

  /**
   * Instantiates a new User comment controller.
   *
   * @param userCommentRepository the user comment repository
   */
  @Autowired
  public UserCommentController(UserCommentRepository userCommentRepository) {
    this.userCommentRepository = userCommentRepository;
  }

  /**
   * Gets a list of comments ordered by their time of creation.
   *
   * @return a list of comments ordered by their time of creation.
   */
  @ApiOperation(value = USER_COMMENT_ALL_SUMMARY, notes = USER_COMMENT_ALL_DESC)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserComment> list() {
    return userCommentRepository.findAllByOrderByCreatedDesc();
  }

  /**
   * Gets a single user comment.
   *
   * @param userCommentId the user comment id
   * @return the user comment
   */
  @ApiOperation(value = USER_COMMENT_DELETE_SUMMARY, notes = USER_COMMENT_DELETE_DESC)
  @GetMapping(value = "{user_comments}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserComment get(@PathVariable("user_comments") UUID userCommentId) {
    return userCommentRepository.findById(userCommentId).get();
  }

  /**
   * Posts a new user comment. Should include a Google ID and text content in the body.
   *
   * @param userComment the user comment
   * @return the response entity
   */
  @ApiOperation(value = USER_COMMENT_POST_SUMMARY, notes = USER_COMMENT_POST_DESC)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserComment> post(@RequestBody UserComment userComment) {
    userCommentRepository.save(userComment);
    return ResponseEntity.created(userComment.getHref()).body(userComment);
  }

  /**
   * Deletes a user comment.
   *
   * @param userCommentId the user comment id
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = USER_COMMENT_PATCH_SUMMARY, notes = USER_COMMENT_PATCH_DESC)
  @DeleteMapping(value = "{userCommentId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("userCommentId") UUID userCommentId) {
    userCommentRepository.deleteById(userCommentId);
  }

}