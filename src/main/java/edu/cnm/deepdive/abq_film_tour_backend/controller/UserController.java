package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.UserRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(GoogleUser.class)
@RequestMapping("/users")
public class UserController {

  private UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository){
    this.userRepository=userRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<GoogleUser> list(){return userRepository.findAllByOrderByIdAsc();}

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GoogleUser> post(@RequestBody GoogleUser googleUser){
    userRepository.save(googleUser);
    return ResponseEntity.created(googleUser.getHref()).body(googleUser);
  }

  @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public GoogleUser get(@PathVariable("userId") UUID userId){
    return userRepository.findById(userId).get();
  }

  @DeleteMapping(value = "{userId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("userId") UUID userId){
    userRepository.deleteById(userId);
  }

}
