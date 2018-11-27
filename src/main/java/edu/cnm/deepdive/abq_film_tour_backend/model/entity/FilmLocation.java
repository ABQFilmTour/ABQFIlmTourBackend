package edu.cnm.deepdive.abq_film_tour_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class FilmLocation {

  @Id
  @GeneratedValue(generator = "uui2d")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "film_location_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  //These fields exist in the city data but are critical to the entity and should be the minimum
  //requirements for submitted data.
  @NonNull
  @Column(nullable = false, updatable = false)
  private double longCoordinate;
  @NonNull
  @Column(nullable = false, updatable = false)
  private double latCoordinate;

  //Even if a location may not necessarily have a site name, it probably should be required if this
  //data will be displayed in a a table.
  @NonNull
  @Column(nullable = false, updatable = false)
  private String siteName;

  //Film and series listed on imdb are 7 digit ids prefixed with "tt".
  //can be accessed with www.omdbapi.com/
  @NonNull
  @Column(nullable = false, updatable = false)
  private String imdbid;

  //These fields exist in the city data and may be useful, perhaps could be mentioned in a comment,
  // but do not seem critically important.
  @Column(nullable = true, updatable = false)
  private String address;
  @Column(nullable = true, updatable = false)
  private long ShootDate;
  @Column(nullable = true, updatable = false)
  private String originalDetails;

  public FilmLocation() {
    // empty constructor
  }

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

}