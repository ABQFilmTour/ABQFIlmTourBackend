package edu.cnm.deepdive.abq_film_tour_backend.controller;

import static edu.cnm.deepdive.abq_film_tour_backend.controller.Constants.*;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
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
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = IMAGE_ALL_SUMMARY, notes = IMAGE_ALL_DESC)
  @ApiResponses({
      @ApiResponse(code = HttpServletResponse.SC_OK, message = RESPONSE_SUCCESSFUL),
      @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = RESPONSE_401),
      @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = RESPONSE_403_USER)
  })
  public List<Image> list() {
    return imageRepository.findAllByOrderByCreatedDesc();
  }

  /**
   * Gets an image.
   *
   * @param imageId the image id
   * @return the image
   */
  @GetMapping(value = "{imageId}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = IMAGE_GET_SUMMARY, notes = IMAGE_GET_DESC)
  @ApiResponses({
      @ApiResponse(code = HttpServletResponse.SC_OK, message = RESPONSE_SUCCESSFUL),
      @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = RESPONSE_401),
      @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = RESPONSE_403_USER)
  })
  public Image get(@PathVariable("imageId") UUID imageId) {
    return imageRepository.findById(imageId).get();
  }

  /**
   * Posts an image. Posting should not be done directly, it should be done on a specific FilmLocation endpoint.
   *
   * @param image the image
   * @return the response entity
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = IMAGE_POST_SUMMARY, notes = IMAGE_POST_BAD_DESC)
  @ApiResponses({
      @ApiResponse(code = HttpServletResponse.SC_OK, message = RESPONSE_SUCCESSFUL),
      @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = RESPONSE_401),
      @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = RESPONSE_403_USER)
  })
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
  @DeleteMapping(value = "{imageId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @ApiOperation(value = IMAGE_DELETE_SUMMARY, notes = IMAGE_DELETE_DESC)
  @ApiResponses({
      @ApiResponse(code = HttpServletResponse.SC_NO_CONTENT, message = RESPONSE_SUCCESSFUL),
      @ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = RESPONSE_401),
      @ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = RESPONSE_403_SUPER)
  })
  public void delete(@PathVariable("imageId") UUID imageId) {
    imageRepository.deleteById(imageId);
  }

}