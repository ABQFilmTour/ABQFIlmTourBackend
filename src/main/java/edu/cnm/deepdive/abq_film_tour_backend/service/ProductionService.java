package edu.cnm.deepdive.abq_film_tour_backend.service;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * A Retrofit service used to access IMDb information from the OMDb API and return a Production
 * entity with the serialized data.
 */
public interface ProductionService {

  //www.omdbapi.com/?i=tt0903747&apikey=12345678

  /**
   * Gets the Production entity with serialized data.
   *
   * @param imdbID the 8 digit imdb id starting with tt
   * @param apikey the apikey (in config/application.properties)
   * @return a call to a Production entity.
   */
  @GET("/")
  Call<Production> get(@Query("i") String imdbID, @Query("apikey") String apikey);

}
