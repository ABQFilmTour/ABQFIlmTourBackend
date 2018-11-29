package edu.cnm.deepdive.abq_film_tour_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.URI;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

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

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

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
  private String imdbid;

  //These fields exist in the city data and may be useful, perhaps could be mentioned in a comment,
  // but do not seem critically important.
  private String address;
  private long ShootDate;
  private String originalDetails;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getSiteName() {
    return siteName;
  }

  public void setSiteName(String siteName) {
    this.siteName = siteName;
  }

  public String getImdbid() {
    return imdbid;
  }

  public void setImdbid(String imdbid) {
    this.imdbid = imdbid;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public long getShootDate() {
    return ShootDate;
  }

  public void setShootDate(long shootDate) {
    ShootDate = shootDate;
  }

  public String getOriginalDetails() {
    return originalDetails;
  }

  public void setOriginalDetails(String originalDetails) {
    this.originalDetails = originalDetails;
  }

  public double getLongCoordinate() {
    return longCoordinate;
  }

  public void setLongCoordinate(double longCoordinate) {
    this.longCoordinate = longCoordinate;
  }

  public double getLatCoordinate() {
    return latCoordinate;
  }

  public void setLatCoordinate(double latCoordinate) {
    this.latCoordinate = latCoordinate;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(FilmLocation.class, id).toUri();
  }

}