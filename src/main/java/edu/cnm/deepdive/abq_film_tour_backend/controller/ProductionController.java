package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Production entity.
 */
@RestController
@ExposesResourceFor(ProductionController.class)
@RequestMapping("/productions")
public class ProductionController {

  private ProductionRepository productionRepository;

  /**
   * Instantiates a new Production controller.
   *
   * @param productionRepository the production repository
   */
  @Autowired
  public ProductionController(ProductionRepository productionRepository) {
    this.productionRepository = productionRepository;
  }

  /**
   * GETs a list of productions ordered by their ID.
   *
   * @return a list of productions ordered by their ID.
   */
  @ApiOperation(value = "Orders Productions", notes = "Orders by Id ascending.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Production> list() { return productionRepository.findAllByOrderByIdAsc();}

  /**
   * Post response entity.
   *
   * @param production the production
   * @return the response entity
   */
  @ApiOperation(value = "Post Production", notes = "Saves production to production repository")
  @Secured("ROLE_SUPER")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Production> post(@RequestBody Production production) {
    productionRepository.save(production);
    return ResponseEntity.created(production.getHref()).body(production);
  }

  /**
   * Get production.
   *
   * @param productionId the production id
   * @return the production
   */
  @ApiOperation(value = "Gets a production", notes = "Finds production by the production UUID")
  @GetMapping(value = "{productionId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Production get(@PathVariable("productionId") UUID productionId){
    return productionRepository.findById(productionId).get();
  }

  /**
   * Delete.
   *
   * @param productionId the production id
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = "Deletes a production", notes = "Enables you to delete a production from database")
  @DeleteMapping(value = "{productionId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("productionId") UUID productionId) {
    productionRepository.deleteById(productionId);
  }

  /**
   * Patches a production. This will overwrite everything. If just changing one field all other
   * current fields must be included.
   *
   * @param production an updated production.
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = "Patches a production", notes = "Enables you to edit a production from database")
  @PatchMapping
  public void patch(@RequestBody Production production) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    productionRepository.save(production);
  }

}
