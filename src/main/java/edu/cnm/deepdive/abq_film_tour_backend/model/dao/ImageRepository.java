package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, UUID> {

  List<Image> findAllByOrderByCreatedDesc();

  List<Image> findAllByFilmLocationOrderByCreatedDesc(FilmLocation filmLocation);

  List<Image> findAllByGoogleId(String googleId);

  List<Image> findAllByGoogleIdOrderByCreatedDesc(String googleId);

}
