package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import java.util.List;
import java.util.UUID;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCommentRepository extends CrudRepository<UserComment, UUID> {

  List<UserComment> findAllByOrderByCreatedDesc();

  List<UserComment> findAllByFilmLocationOrderByCreatedDesc(FilmLocation filmLocation);

  List<UserComment> findAllByGoogleId(String googleId);

  List<UserComment> findAllByGoogleIdOrderByCreatedDesc(String googleId);

}
