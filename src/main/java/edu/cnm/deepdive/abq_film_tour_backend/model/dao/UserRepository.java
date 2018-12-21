package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.GoogleUser;
import edu.cnm.deepdive.abq_film_tour_backend.service.GoogleTokenServices;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<GoogleUser, UUID> {

  List<GoogleUser> findAllByOrderByIdAsc();

  GoogleUser findByGoogleId(String googleId);

}