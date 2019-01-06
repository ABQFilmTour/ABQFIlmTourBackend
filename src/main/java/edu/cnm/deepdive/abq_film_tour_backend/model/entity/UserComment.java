package edu.cnm.deepdive.abq_film_tour_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * A user comment submitted to a specific location. City comments are submitted automatically in
 * the Parser class.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class UserComment {

  private static EntityLinks entityLinks;

  @PostConstruct
  private void init() {
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    UserComment.entityLinks = entityLinks;
  }

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "user_comment_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  @NonNull
  @JsonIgnore
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "film_location_id", nullable = false, updatable = false)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private FilmLocation filmLocation;

  @NonNull
  @Column(length = 4096, nullable = false)
  private String text;

  /**
   * The Google ID of the user who submitted this location.
   */
  private String googleId;

  /**
   * The full name of the Google user who submitted this content.
   */
  private String userName;

  /**
   * The URL to the profile picture of the Google user who submitted this content.
   */
  private String userPictureUrl;

  /**
   * Flag to verify that a comment has been approved by an admin and can be displayed if security
   * is tightened. Probably unnecessary for now, but better to have if we implement later.
   */
  private boolean approved;

  /**
   * Gets id.
   *
   * @return the id
   */
  @ApiModelProperty(value = "Internal ID for this location.", readOnly = true)
  public UUID getId() {
    return id;
  }

  /**
   * Gets the time of creation.
   *
   * @return the time of creation
   */
  @JsonIgnore
  @ApiModelProperty(value = "The time this entity was created.", readOnly = true)
  public Date getCreated() {
    return created;
  }

  @JsonProperty
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   * Gets the text of the comment. 4096 character maximum.
   *
   * @return the text of the comment.
   */
  @ApiModelProperty(value = "The text content of this comment. 4096 character max")
  public String getText() {
    return text;
  }

  /**
   * Sets text of the comment.  4096 character maximum.
   *
   * @param text the text of the comment.
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Gets film location associated with the entity.
   *
   * @return the film location associated with the entity.
   */
  @ApiModelProperty(value = "The Film Location associated with this entity.", readOnly = true)
  public FilmLocation getFilmLocation() {
    return filmLocation;
  }

  /**
   * Sets film location associated with the entity.
   *
   * @param filmlocation the film location associated with the entity.
   */
  public void setFilmLocation(
      FilmLocation filmlocation) {
    this.filmLocation = filmlocation;
  }

  /**
   * Gets href.
   *
   * @return the href
   */
  public URI getHref() {
    return entityLinks.linkForSingleResource(FilmLocation.class, id).toUri();
  }

  /**
   * Checks if this content is approved.
   *
   * @return the approval status
   */
  @ApiModelProperty(value = "The approval status of the location.", required = true)
  public boolean isApproved() {
    return approved;
  }

  /**
   * Changes this content's approval status.
   *
   * @param approved a boolean.
   */
  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  /**
   * Used to assign Google information to user submitted content.
   */
  @ApiModelProperty(value = "Google ID of the user")
  public String getGoogleId() {
    return googleId;
  }

  /**
   * Used to assign Google information to user submitted content.
   */
  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  /**
   * Gets the full name of the Google user who submitted this content.
   * @return the full name of the Google user who submitted this content.
   */
  @ApiModelProperty(value = "The full name of the Google user who submitted this content")
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the name of the user who submitted this content.
   * @param userName the full name of the Google user
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Gets the URL of the Google user's profile image.
   * @return the URL of the Google user's profile image.
   */
  @ApiModelProperty(value = "The URL of the Google user's profile image.")
  public String getUserPictureUrl() {
    return userPictureUrl;
  }

  /**
   * Sets the URL of the Google user's profile image.
   * @param userPictureUrl the URL of the Google user's profile image.
   */
  public void setUserPictureUrl(String userPictureUrl) {
    this.userPictureUrl = userPictureUrl;
  }
}