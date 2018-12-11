package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserCommentRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.UUID;
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
   * GETs a list of comments ordered by their ID.
   *
   * @return a list of comments ordered by their ID.
   */
  @ApiOperation(value = "")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserComment> list() {
    return userCommentRepository.findAllByOrderByIdAsc();
  }

  /**
   * Post response entity.
   *
   * @param userComment the user comment
   * @return the response entity
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserComment> post(@RequestBody UserComment userComment) {
    userCommentRepository.save(userComment);
    return ResponseEntity.created(userComment.getHref()).body(userComment);
  }

  /**
   * Get user comment.
   *
   * @param userCommentId the user comment id
   * @return the user comment
   */
  @GetMapping(value = "{user_comments}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserComment get(@PathVariable("user_comments") UUID userCommentId) {
    UserComment userComment = userCommentRepository.findById(userCommentId).get();
    return userComment;
  }

  /**
   * Delete.
   *
   * @param userCommentId the user comment id
   */
  @DeleteMapping(value = "{userCommentId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("userCommentId") UUID userCommentId) {
    userCommentRepository.deleteById(userCommentId);
  }

}