package edu.cnm.deepdive.abq_film_tour_backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:secret.properties")
public class Config {

  @Value("${api_key}")
  private String apikey;

  @Bean
  public String apiKey() {
    return this.apikey;
  }

}
