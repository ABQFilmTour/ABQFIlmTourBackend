package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<GoogleUser, UUID> {

  List<GoogleUser> findAllByOrderByGoogleNameAsc();

  GoogleUser findByGoogleId(String googleId);

}