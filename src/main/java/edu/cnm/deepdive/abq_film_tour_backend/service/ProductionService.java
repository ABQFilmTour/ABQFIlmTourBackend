package edu.cnm.deepdive.abq_film_tour_backend.service;

import edu.cnm.deepdive.abq_film_tour_backend.model.entity.Production;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductionService {

  //www.omdbapi.com/?i=tt0903747&apikey=12345678

  @GET("/")
  Call<Production> get(@Query("i") String imdbID, @Query("apikey") String apikey);

}
