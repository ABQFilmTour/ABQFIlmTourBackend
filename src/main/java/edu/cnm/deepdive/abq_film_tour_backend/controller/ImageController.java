package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for the Image entity, child of Film Location, requires a User.
 */
@RestController
@ExposesResourceFor(Image.class)
@RequestMapping("/images")
public class ImageController {

  private ImageRepository imageRepository;

  /**
   * Instantiates a new Image controller.
   *
   * @param imageRepository the image repository
   */
  @Autowired
  public ImageController(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  /**
   * GETs a list of productions ordered by their ID.
   *
   * @return a list of productions ordered by their ID.
   */
  @ApiOperation(value = "Orders Images", notes = "Orders by Id ascending.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Image> list() {
    return imageRepository.findAllByOrderByIdAsc();
  }

  /**
   * Post response entity.
   *
   * @param image the image
   * @return the response entity
   */
  @ApiOperation(value = "Post Image", notes = "Saves image to image repository")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Image> post(@RequestBody Image image) {
    imageRepository.save(image);
    return ResponseEntity.created(image.getHref()).body(image);
  }

  /**
   * Get image.
   *
   * @param imageId the image id
   * @return the image
   */
  @ApiOperation(value = "Gets an image", notes = "Finds image by the image UUID")
  @GetMapping(value = "{imageId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Image get(@PathVariable("imageId") UUID imageId) {
    return imageRepository.findById(imageId).get();
  }

  /**
   * Delete.
   *
   * @param imageId the image id
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = "Deletes an image", notes = "Enables you to delete an image from database")
  @DeleteMapping(value = "{imageId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("imageId") UUID imageId) {
    imageRepository.deleteById(imageId);
  }

}