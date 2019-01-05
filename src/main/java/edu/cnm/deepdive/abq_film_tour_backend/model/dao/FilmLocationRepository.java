package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface FilmLocationRepository extends CrudRepository<FilmLocation, UUID> {

  List<FilmLocation> findAllByOrderByCreatedDesc();

}