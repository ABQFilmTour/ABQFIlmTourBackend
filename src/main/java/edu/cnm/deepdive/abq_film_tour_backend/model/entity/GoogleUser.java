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

  /**
   * Persistent Google Analytics user ID to reference the user's Google account information.
   */
  private String googleId;

  /**
   * The full name on a Google account.
   */
  private String googleName;

  /**
   * The email address belonging to a Google user.
   */
  private String gmailAddress;

  /**
   * Flag to indicate whether or not a user is banned.
   */
  private boolean banned;

  /**
   * Reason for a ban, this will display in the error description when a 403 is thrown.
   */
  private String banReason;

  /**
   * Indicates a user's privileges. Can be "user", "admin" or "superuser". Mostly only for records.
   */
  private String userRole;

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

  /**
   * Requests the user's banned status.
   *
   * @return the banned status of the user.
   */
  public boolean isBanned() {
    return banned;
  }

  /**
   * Sets the banned flag to a given value.
   *
   * @param banned a boolean.
   */
  public void setBanned(boolean banned) {
    this.banned = banned;
  }

  /**
   * Gets ban reason.
   *
   * @return the ban reason
   */
  public String getBanReason() {
    return banReason;
  }

  /**
   * Sets ban reason.
   *
   * @param banReason the ban reason
   */
  public void setBanReason(String banReason) {
    this.banReason = banReason;
  }

  /**
   * Gets user role.
   *
   * @return the user role
   */
  public String getUserRole() {
    return userRole;
  }

  /**
   * Sets user role.
   *
   * @param userRole the user role
   */
  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
}
