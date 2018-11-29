package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UUID> {

  List<User> findAllByOrderByFilmlocationAsc();

}
