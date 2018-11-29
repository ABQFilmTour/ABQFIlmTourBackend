package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserCommentRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
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

@RestController
@ExposesResourceFor(FilmLocation.class)
@RequestMapping("/film_locations")
public class FilmLocationController {

  private FilmLocationRepository filmLocationRepository;
  private UserCommentRepository userCommentRepository;
  private UserRepository userRepository;
  private ImageRepository imageRepository;

  @Autowired
  public FilmLocationController(FilmLocationRepository filmLocationRepository,
      UserCommentRepository userCommentRepository,
      UserRepository userRepository,
      ImageRepository imageRepository) {
    this.filmLocationRepository = filmLocationRepository;
    this.userCommentRepository = userCommentRepository;
    this.userRepository = userRepository;
    this.imageRepository = imageRepository;
  }

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

  @GetMapping(value = "{filmLocationId}/images", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Image> getImages(@PathVariable UUID filmLocationId) {
    return imageRepository.findAllByFilmLocationOrderByCreatedDesc
        (filmLocationRepository.findById(filmLocationId).get());
  }

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

  @GetMapping(value = "{filmLocationId}/user_comments", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserComment> getUserComments(@PathVariable UUID filmLocationId) {
    return userCommentRepository.findAllByFilmLocationOrderByCreatedDesc
        (filmLocationRepository.findById(filmLocationId).get());
  }

  @GetMapping(value = "{filmLocationId}/user_comments/{userCommentId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserComment get(@PathVariable UUID filmLocationId, @PathVariable UUID userCommentId){
    UserComment userComment = userCommentRepository.findById(userCommentId).get();
    return userComment;
  }

  @DeleteMapping(value = "{filmLocationId}/user_comments/{userCommentId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID filmLocationId, @PathVariable("userCommentId") UUID userCommentId){
    userCommentRepository.deleteById(userCommentId);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<FilmLocation> list() {
    return filmLocationRepository.findAllByOrderByIdAsc();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FilmLocation> post(@RequestBody FilmLocation filmLocation) {
    filmLocationRepository.save(filmLocation);
    return ResponseEntity.created(filmLocation.getHref()).body(filmLocation);
  }

  @GetMapping(value = "{filmLocationId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public FilmLocation get(@PathVariable("filmLocationId") UUID filmLocationId) {
    return filmLocationRepository.findById(filmLocationId).get();
  }

  @DeleteMapping(value = "{filmLocationId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("filmLocationId") UUID filmLocationId) {
    filmLocationRepository.deleteById(filmLocationId);
  }

  @PatchMapping
  public void patch(@RequestBody FilmLocation filmLocation) {
    filmLocationRepository.save(filmLocation);
  }

}