package edu.cnm.deepdive.abq_film_tour_backend.model.dao;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ProductionRepository extends CrudRepository<Production, UUID> {

}
