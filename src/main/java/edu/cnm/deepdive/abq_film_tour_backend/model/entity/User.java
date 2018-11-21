package edu.cnm.deepdive.abq_film_tour_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonView
@Component
@Entity
public class User {

  @Column (nullable = false, updatable = false)
  UUID id;

  //persistent Google Analytics user ID
  @Column (nullable = false, updatable = false)
  String googleId;

  //Google account name - maybe brea
  @Column (nullable = false, updatable = false)
  String googleName;

  @Column (nullable = false, updatable = false)
  String gmailAddress;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getGoogleId() {
    return googleId;
  }

  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  public String getGoogleName() {
    return googleName;
  }

  public void setGoogleName(String googleName) {
    this.googleName = googleName;
  }

  public String getGmailAddress() {
    return gmailAddress;
  }

  public void setGmailAddress(String gmailAddress) {
    this.gmailAddress = gmailAddress;
  }
}
