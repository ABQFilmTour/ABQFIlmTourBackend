package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserCommentRepository extends CrudRepository<UserComment, UUID> {


//TODO add delete and insert


  @Query(value = "SELECT * FROM UserComment "
      + "WHERE film_location_id = :filmLocationId ORDER BY timestamp",
  nativeQuery = true)
  List<UserComment> selectByLocation(long filmLocationId);

  @Query(value = "SELECT * FROM UserComment WHERE user_id = :userId ORDER BY timestamp",
  nativeQuery = true)
  List<UserComment> selectByUser(long userId);

}
