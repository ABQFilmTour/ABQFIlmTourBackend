package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ImageRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Image;
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
@ExposesResourceFor(Image.class)
@RequestMapping("/images")
public class ImageController {
private ImageRepository imageRepository;

  @Autowired
  public ImageController(ImageRepository imageRepository){
    this.imageRepository = imageRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Image> list(){return imageRepository.findAllByOrderByIdAsc();}

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Image> post(@RequestBody Image image){
    imageRepository.save(image);
    return ResponseEntity.created(image.getHref()).body(image);
  }

  @GetMapping(value = "{imadeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Image get(@PathVariable("imageId") UUID imageId){
    return imageRepository.findById(imageId).get();
  }

  @DeleteMapping(value = "{imageId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("imageId") UUID imageId){
    imageRepository.deleteById(imageId);
  }


}
