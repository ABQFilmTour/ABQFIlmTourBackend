package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, UUID> {

  List<Image> findAllByOrderByIdAsc();

////FIXME add user getters and setters to Image entity
//  List<Image> findAllByOrderByUserAsc();
}
