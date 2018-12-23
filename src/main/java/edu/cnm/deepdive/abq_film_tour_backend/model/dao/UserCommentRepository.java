package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserCommentRepository extends CrudRepository<UserComment, UUID> {

  List<UserComment> findAllByOrderByIdAsc();
  
  List<UserComment> findAllByFilmLocationOrderByCreatedDesc(FilmLocation filmLocation);

  List<UserComment> findAllByUser(GoogleUser user);

}
