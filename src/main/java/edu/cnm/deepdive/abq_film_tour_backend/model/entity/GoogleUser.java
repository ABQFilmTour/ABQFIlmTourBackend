package edu.cnm.deepdive.abq_film_tour_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URI;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@Entity
public class GoogleUser {

  private static EntityLinks entityLinks;

  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    GoogleUser.entityLinks = entityLinks;
  }

  @Id
  @GeneratedValue(generator = "uui2d")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "user_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  UUID id;

  //persistent Google Analytics user ID
  String googleId;

  //Google account name - maybe brea
  String googleName;

  String gmailAddress;

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

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

  public URI getHref(){return entityLinks.linkForSingleResource(GoogleUser.class, id).toUri();}
}
