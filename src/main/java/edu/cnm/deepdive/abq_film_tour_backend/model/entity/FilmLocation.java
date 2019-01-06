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
 * The Film Location entity represents the physical map location. Site name, long and lat
 * coordinates are the most critical attributes. Data for initial population is retrieved from the
 * city of Albuquerque, some fields are inherited from their dataset (such as Original Details) but
 * information from these should be referenced in comments.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class FilmLocation {

  private static EntityLinks entityLinks;

  @PostConstruct
  private void initEntityLinks() {
    //Sends a request to the entityLinks to ensure it gets set
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    //Constructs entitylinks after init request is null
    FilmLocation.entityLinks = entityLinks;
  }

  /**
   * The transient internal ID for the user who submitted this location, should be generally
   * disfavored for GoogleID.
   */
  @Transient
  private UUID userId;

  /**
   * The user who submitted this location.
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", updatable = false)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private GoogleUser user;

  /**
   * The time of creation for this location.
   */
  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  /**
   * The internal ID for this location.
   */
  @Id
  @GeneratedValue(generator = "uui2d")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "film_location_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  /**
   * The longitude coordinate for this location.
   */
  private double longCoordinate;
  /**
   * The latitude coordinate for this location.
   */
  private double latCoordinate;

  /**
   * The name of the site.
   */
  @NonNull
  @Column(nullable = false)
  private String siteName;

  /**
   * Film and series listed on imdb are 7 digit ids prefixed with "tt". can be accessed with
   * www.omdbapi.com
   */
  private String imdbId;

  /**
   * The production ID associated with this location.
   */
  @Transient
  private String productionId;

  @ManyToOne(fetch = FetchType.EAGER)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private Production production;

  /**
   * This field exists in the city data and is used to construct a comment with information about
   * the latest shoot.
   */
  private String address;
  /**
   * This field exists in the city data and is used to construct a comment with information about
   * the latest shoot.
   */
  private long shootDate;
  /**
   * This field exists in the city data and is used to construct a comment with information about
   * the latest shoot.
   */
  private String originalDetails;

  /**
   * Flag to verify that a location has been approved by an admin and can be displayed if security
   * is tightened.
   */
  private boolean approved;

  @Transient
  private String googleId;

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
   * Sets id.
   *
   * @param id the id
   */
  public void setId(UUID id) {
    this.id = id;
  }

  /**
   * Gets the transient user id of the user who submitted the entity.
   *
   * @return the transient user id of the user who submitted the entity.
   */
  @ApiModelProperty(value = "Transient ID to reference the user in a post.")
  public UUID getUserId() {
    return userId;
  }

  /**
   * Sets the transient user id of the user who submitted the entity.
   *
   * @param userId the transient user id of the user who submitted the entity.
   */
  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  /**
   * Gets the user who submitted this location.
   *
   * @return the user who submitted this location.
   */
  @ApiModelProperty(value = "The user who submitted this location.", readOnly = true)
  public GoogleUser getUser() {
    return user;
  }

  /**
   * Sets the user who submitted this location.
   *
   * @param user the user who submitted this location.
   */
  public void setUser(GoogleUser user) {
    this.user = user;
  }

  /**
   * Gets time of creation.
   *
   * @return the time of creation
   */
  @JsonIgnore
  @ApiModelProperty(value = "The time this entity was created.", readOnly = true)
  public Date getCreated() {
    return created;
  }

  /**
   * Sets time of creation.
   *
   * @param created the time of creation
   */
  @JsonProperty
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Gets site name.
   *
   * @return the site name
   */
  @ApiModelProperty(value = "The name of the site.", required = true)
  public String getSiteName() {
    return siteName;
  }

  /**
   * Sets site name.
   *
   * @param siteName the site name
   */
  public void setSiteName(String siteName) {
    this.siteName = siteName;
  }

  /**
   * Gets imdb id.
   *
   * @return the imdb id
   */
  @ApiModelProperty(value = "The IMDb ID for this location. Included in city data entries.")
  public String getImdbId() {
    return imdbId;
  }

  /**
   * Sets imdb id.
   *
   * @param imdbId the imdb id
   */
  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  /**
   * Gets address.
   *
   * @return the address
   */
  @ApiModelProperty(value = "The address for this location. Included in city data entries.")
  public String getAddress() {
    return address;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets shoot date.
   *
   * @return the shoot date
   */
  @ApiModelProperty(value = "The time of the last shoot in epoch date format. Included in city data entries.")
  public long getShootDate() {
    return shootDate;
  }

  /**
   * Sets shoot date.
   *
   * @param shootDate the shoot date
   */
  public void setShootDate(long shootDate) {
    this.shootDate = shootDate;
  }

  /**
   * Gets original details.
   *
   * @return the original details
   */
  @ApiModelProperty(value = "General information about the last shoot. Included in city data entries")
  public String getOriginalDetails() {
    return originalDetails;
  }

  /**
   * Sets original details.
   *
   * @param originalDetails the original details
   */
  public void setOriginalDetails(String originalDetails) {
    this.originalDetails = originalDetails;
  }

  /**
   * Gets longitude coordinate.
   *
   * @return the longitude coordinate
   */
  @ApiModelProperty(value = "The longitude coordinate of the location.", required = true)
  public double getLongCoordinate() {
    return longCoordinate;
  }

  /**
   * Sets longitude coordinate.
   *
   * @param longCoordinate the longitude coordinate
   */
  public void setLongCoordinate(double longCoordinate) {
    this.longCoordinate = longCoordinate;
  }

  /**
   * Gets latitude coordinate.
   *
   * @return the latitude coordinate
   */
  @ApiModelProperty(value = "The latitude coordinate of the location.", required = true)
  public double getLatCoordinate() {
    return latCoordinate;
  }

  /**
   * Sets latitude coordinate.
   *
   * @param latCoordinate the latitude coordinate
   */
  public void setLatCoordinate(double latCoordinate) {
    this.latCoordinate = latCoordinate;
  }

  /**
   * Gets production.
   *
   * @return the production
   */
  @ApiModelProperty(value = "The production (film or television series) associated with this location.", readOnly = true)
  public Production getProduction() {
    return production;
  }

  /**
   * Sets production.
   *
   * @param production the production
   */
  public void setProduction(Production production) {
    this.production = production;
  }

  /**
   * Gets production id.
   *
   * @return the production id
   */
  @ApiModelProperty(value = "The transient ID of the production, used to reference during a post.")
  public String getProductionId() {
    return productionId;
  }

  /**
   * Sets production id.
   *
   * @param productionId the production id
   */
  public void setProductionId(String productionId) {
    this.productionId = productionId;
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
   * Used transiently to assign Google information to user submitted content.
   */
  @ApiModelProperty(value = "Transient Google ID of the user, used to reference the user during a post.")
  public String getGoogleId() {
    return googleId;
  }

  /**
   * Used transiently to assign Google information to user submitted content.
   */
  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }
}