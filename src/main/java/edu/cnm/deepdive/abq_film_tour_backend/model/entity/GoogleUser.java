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

/**
 * This entity represents a Google account belonging to a user.
 */
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
  private UUID id;

  //persistent Google Analytics user ID
  private String googleId;

  //Google account name
  private String googleName;

  private String gmailAddress;

  //Flag to check if a user is banned from using the app
  private boolean banned;

  //Reason for any ban, maybe this could have a value without a ban to display a warning message to
  // a user.
  private String banReason;

  //Indicates a user's privileges. Mostly only for records.
  private String userRole = "user";

  private static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public UUID getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Gets google id - a unique identifier for Google accounts.
   *
   * @return the google id
   */
  public String getGoogleId() {
    return googleId;
  }

  /**
   * Sets google id - a unique identifier for Google accounts.
   *
   * @param googleId the google id
   */
  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  /**
   * Gets the full name on the Google account.
   *
   * @return the full name on the Google account.
   */
  public String getGoogleName() {
    return googleName;
  }

  /**
   * Sets the name associated with the Google account.
   *
   * @param googleName the name associated with the Google account.
   */
  public void setGoogleName(String googleName) {
    this.googleName = googleName;
  }

  /**
   * Gets GMail address associated with the Google account.
   *
   * @return the GMail address associated with the Google account.
   */
  public String getGmailAddress() {
    return gmailAddress;
  }

  /**
   * Sets GMail address associated with the Google account..
   *
   * @param gmailAddress the GMail address associated with the Google account.
   */
  public void setGmailAddress(String gmailAddress) {
    this.gmailAddress = gmailAddress;
  }

  /**
   * Get href uri.
   *
   * @return the uri
   */
  public URI getHref(){return entityLinks.linkForSingleResource(GoogleUser.class, id).toUri();}

  public boolean isBanned() {
    return banned;
  }

  public void setBanned(boolean banned) {
    this.banned = banned;
  }

  public String getBanReason() {
    return banReason;
  }

  public void setBanReason(String banReason) {
    this.banReason = banReason;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
}
