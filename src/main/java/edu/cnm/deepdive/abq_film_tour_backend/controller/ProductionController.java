package edu.cnm.deepdive.abq_film_tour_backend.controller;

import edu.cnm.deepdive.abq_film_tour_backend.model.dao.ProductionRepository;
import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import edu.cnm.deepdive.abq_film_tour_backend.service.ProductionService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

/**
 * Controller for the Production entity.
 */
@RestController
@ExposesResourceFor(ProductionController.class)
@RequestMapping("/productions")
public class ProductionController {

  private static final String OMDB_POSTER_URL_FORMAT = "https://img.omdbapi.com/?i=%s&h=%s&apikey=%s";
  private static final int OMDB_POSTER_HEIGHT = 600;
  private ProductionRepository productionRepository;
  private String apikey;

  /**
   * Instantiates a new Production controller.
   *
   * @param productionRepository the production repository
   */
  @Autowired
  public ProductionController(ProductionRepository productionRepository) {
    this.productionRepository = productionRepository;
  }

  @Autowired
  @Qualifier("apiKey")
  public void setApikey(String apikey) {
    this.apikey = apikey;
  }

  /**
   * GETs a list of productions ordered by their ID.
   *
   * @return a list of productions ordered by their ID.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Production> list() { return productionRepository.findAllByOrderByIdAsc();}

  /**
   * Post response entity.
   *
   * @param production the production
   * @return the response entity
   */
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
  @DeleteMapping(value = "{productionId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("productionId") UUID productionId) {
    productionRepository.deleteById(productionId);
  }

  /**
   * Patches a production. This will overwrite everything. if just changing one field all other
   * current fields must be included.
   *
   * @param production an updated production.
   */
  @Secured("ROLE_SUPER")
  @PatchMapping
  public void patch(@RequestBody Production production) {
    // This will overwrite everything,
    // if just changing one field all other current fields must be included
    productionRepository.save(production);
  }

  /**
   * Creates an OMDB url to retrieve the poster image using the supplied api key.
   */
  private String createProductionPosterUrl(Production production) {
    String imdbId = production.getImdbId();
    String height = String.valueOf(OMDB_POSTER_HEIGHT);
    String apikey = this.apikey;
    return String.format(OMDB_POSTER_URL_FORMAT, imdbId, height, apikey);
  }

  @GetMapping(value = "{productionId}/poster", produces = MediaType.IMAGE_JPEG_VALUE)
  public StreamingResponseBody getPoster(@PathVariable("productionId") UUID productionId)
      throws IOException {
//    String url = createProductionPosterUrl(productionRepository.findById(productionId).get());
//    OkHttpClient client = new OkHttpClient();
//    Request request = new Request.Builder().url(url)
//        .build();
//    Response response = client.newCall(request).execute();

    Retrofit.Builder builder = new Retrofit.Builder()
        .baseUrl("https://img.omdbapi.com")
        .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    Call<ResponseBody> call = retrofit.create(ProductionService.class).getPoster(productionRepository.findById(productionId).get().getImdbId(), "600", this.apikey);
    Response<ResponseBody> response = call.execute();
    InputStream inputStream = response.body().byteStream();
    return outputStream -> {
      int transfer;
      while ((transfer = inputStream.read()) >= 0) {
        outputStream.write(transfer);
      }
      outputStream.flush();
    };

  }

}
