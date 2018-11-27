package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<FilmLocation, UUID> {
  @Query(value = "SELECT * FROM Image "
      + "WHERE film_location_id = :filmLocationId ORDER BY timestamp",
      nativeQuery = true)
  List<Image> selectByLocation(long filmLocationId);

  @Query(value = "SELECT * FROM Image WHERE image_id = :imageId ORDER BY timestamp",
      nativeQuery = true)
  List<Image> selectByUser(long imageId);
}
