package edu.cnm.deepdive.abq_film_tour_backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * This is the configuration class. It's primary function is to interpret data that should not be
 * exposed from a given secret.properties file.
 */
@Configuration
@PropertySource(value = "classpath:secret.properties")
public class Config {

  @Value("${api_key}")
  private String apikey;

  @Value("${admin_id}")
  private String adminId;

  @Value("${super_ids}")
  private String[] superIds;

  @Bean
  public String apiKey() {
    return this.apikey;
  }

  @Bean
  public String adminId() {return this.adminId;}

  @Bean
  public String[] superIds() {return this.superIds;}

  @Configuration
  @EnableGlobalMethodSecurity(
      prePostEnabled = true,
      securedEnabled = true,
      jsr250Enabled = true)
  public class MethodSecurityConfig
      extends GlobalMethodSecurityConfiguration {
  }

}
