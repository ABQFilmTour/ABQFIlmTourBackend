package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ProductionRepository extends CrudRepository<Production, UUID> {

  List<Production> findAllByOrderByTitleAsc();

  List<Production> findAllByTypeOrderByTitle(String type);

  Production findByImdbId(String imdbID);

}
