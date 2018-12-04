package edu.cnm.deepdive.abq_film_tour_backend.service;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class RetrofitClientService {

  private static final String BASE_URL = "https://www.omdbapi.com/";
  private Retrofit retrofit;

  @PostConstruct
  public void init() {
    Retrofit.Builder builder = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create());
    retrofit = builder.build();
  }

  public Retrofit getRetrofit() {
    return retrofit;
  }

}
