package edu.cnm.deepdive.abq_film_tour_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

  @Transient
  private UUID userId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", updatable = false)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private GoogleUser user;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @Id
  @GeneratedValue(generator = "uui2d")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "film_location_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  //These fields exist in the city data but are critical to the entity and should be the minimum
  //requirements for submitted data.
  private double longCoordinate;
  private double latCoordinate;

  //Even if a location may not necessarily have a site name, it probably should be required if this
  //data will be displayed in a a table.
  @NonNull
  @Column(nullable = false)
  private String siteName;

  //Film and series listed on imdb are 7 digit ids prefixed with "tt".
  //can be accessed with www.omdbapi.com/
  private String imdbId;

  @Transient
  private String productionId;

  @ManyToOne(fetch = FetchType.EAGER)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private Production production;

  //These fields exist in the city data and may be useful, perhaps could be mentioned in a comment,
  // but do not seem critically important.
  private String address;
  private long shootDate;
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

  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  public String getGoogleId() {
    return googleId;
  }

  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }
}