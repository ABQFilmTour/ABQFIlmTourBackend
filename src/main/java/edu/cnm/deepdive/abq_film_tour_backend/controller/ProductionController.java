package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.FilmLocationRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.FilmLocation;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(ProductionController.class)
@RequestMapping("/productions")
public class ProductionController {

  ProductionRepository productionRepository;
  FilmLocationRepository filmLocationRepository;

  @Autowired
  public ProductionController(ProductionRepository productionRepository, FilmLocationRepository filmLocationRepository) {
    this.productionRepository = productionRepository;
    this.filmLocationRepository = filmLocationRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Production> list() { return productionRepository.findAllByOrderByIdAsc();}

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Production> post(@RequestBody Production production) {
    productionRepository.save(production);
    return ResponseEntity.created(production.getHref()).body(production);
  }

  @GetMapping(value = "{productionId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Production get(@PathVariable("productionId") UUID productionId){
    return productionRepository.findById(productionId).get();
  }

  @DeleteMapping(value = "{productionId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("productionId") UUID productionId) {
    productionRepository.deleteById(productionId);
  }

  @PatchMapping
  public void patch(@RequestBody Production production) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    productionRepository.save(production);
  }

}
