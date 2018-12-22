package edu.cnm.deepdive.abq_film_tour_backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * This is the configuration class, primarily for interpreting the API key held in a secret
 * properties file.
 */
@Configuration
@PropertySource(value = "classpath:secret.properties")
public class Config {

  @Value("${api_key}")
  private String apikey;

  @Value("${admin_id}")
  private String adminId;

  @Bean
  public String apiKey() {
    return this.apikey;
  }

  @Bean
  public String adminId() {return this.adminId;}

}
