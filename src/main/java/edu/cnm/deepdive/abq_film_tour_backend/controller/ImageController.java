package edu.cnm.deepdive.abq_film_tour_backend.controller;

import static edu.cnm.deepdive.abq_film_tour_backend.controller.Constants.*;

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
   * Gets a list of images ordered by their time of creation.
   *
   * @return a list of images ordered by their time of creation.
   */
  @ApiOperation(value = IMAGE_LIST_SUMMARY, notes = IMAGE_LIST_DESC)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Image> list() {
    return imageRepository.findAllByOrderByCreatedDesc();
  }

  /**
   * Gets an image.
   *
   * @param imageId the image id
   * @return the image
   */
  @ApiOperation(value = IMAGE_GET_SUMMARY, notes = IMAGE_GET_DESC)
  @GetMapping(value = "{imageId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Image get(@PathVariable("imageId") UUID imageId) {
    return imageRepository.findById(imageId).get();
  }

  /**
   * Posts an image.
   *
   * @param image the image
   * @return the response entity
   */
  @ApiOperation(value = IMAGE_POST_SUMMARY, notes = IMAGE_POST_DESC)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Image> post(@RequestBody Image image) {
    imageRepository.save(image);
    return ResponseEntity.created(image.getHref()).body(image);
  }

  /**
   * Deletes an image.
   *
   * @param imageId the image id
   */
  @Secured("ROLE_SUPER")
  @ApiOperation(value = IMAGE_DELETE_SUMMARY, notes = IMAGE_DELETE_DESC)
  @DeleteMapping(value = "{imageId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("imageId") UUID imageId) {
    imageRepository.deleteById(imageId);
  }

}