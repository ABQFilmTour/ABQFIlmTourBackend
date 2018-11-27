package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(FilmLocation.class)
@RequestMapping("/film_locations")
public class FilmLocationController {

  private FilmLocationRepository filmLocationRepository;

  @Autowired
  public FilmLocationController(FilmLocationRepository filmLocationRepository) {
    this.filmLocationRepository = filmLocationRepository;
  }

}
