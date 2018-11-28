package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.UserComment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserCommentRepository extends CrudRepository<UserComment, UUID> {


  List<UserComment> findAllByOrderByFilmlocationAsc();

  //FIXME add user getters and setters to UserComment entity
//  List<UserComment> findAllByOrderByUserAsc();

}
